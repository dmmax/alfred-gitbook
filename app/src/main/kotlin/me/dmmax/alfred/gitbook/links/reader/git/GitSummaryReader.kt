package me.dmmax.alfred.gitbook.links.reader.git

import me.dmmax.alfred.gitbook.links.reader.SummaryReader
import org.eclipse.jgit.api.Git
import org.eclipse.jgit.internal.storage.dfs.DfsRepositoryDescription
import org.eclipse.jgit.internal.storage.dfs.InMemoryRepository
import org.eclipse.jgit.lib.Repository
import org.eclipse.jgit.revwalk.RevCommit
import org.eclipse.jgit.revwalk.RevWalk
import org.eclipse.jgit.transport.RefSpec
import org.eclipse.jgit.treewalk.TreeWalk
import org.eclipse.jgit.treewalk.filter.PathFilter
import java.io.ByteArrayOutputStream

private const val REMOTE_URL = "https://github.com/dmmax/Knowledge.git"
private const val BRANCH = "main"
private const val FILE_TO_READ = "SUMMARY.md"

class GitSummaryReader : SummaryReader {

    override fun readContent(): String {
        val repository = fetchRepository()
        val lastCommit = findLastCommit(repository)
        return findSummary(repository, lastCommit)
    }

    private fun fetchRepository(): Repository {
        val repoDesc = DfsRepositoryDescription()
        val repo = InMemoryRepository(repoDesc)
        val git = Git(repo)
        git.fetch()
            .setRemote(REMOTE_URL)
            .setRefSpecs(RefSpec("+refs/heads/*:refs/heads/*"))
            .call()
        return repo
    }

    private fun findLastCommit(repository: Repository): RevCommit {
        val lastCommitId = repository.resolve("refs/heads/$BRANCH")
        val revWalk = RevWalk(repository)
        return revWalk.parseCommit(lastCommitId)
    }

    private fun findSummary(repository: Repository, commit: RevCommit): String {
        val tree = commit.tree
        val treeWalk = TreeWalk(repository)
        treeWalk.addTree(tree)
        treeWalk.isRecursive = true
        treeWalk.filter = PathFilter.create(FILE_TO_READ)
        if (!treeWalk.next()) {
            throw RuntimeException("There is no $FILE_TO_READ in the repository $REMOTE_URL")
        }
        val objectId = treeWalk.getObjectId(0)
        val loader = repository.open(objectId)
        val content = ByteArrayOutputStream()
        loader.copyTo(content)
        return String(content.toByteArray())
    }
}