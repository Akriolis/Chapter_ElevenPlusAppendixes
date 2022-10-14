data class Issue (
    val id: String, val project: String, val type: String,
    val priority: String, val description: String
        )

class ImportantIssuesPredicate(val project: String)
    : (Issue) -> Boolean{
    override fun invoke(p1: Issue): Boolean {
        return p1.project == project && p1.isImportant()
    }

    private fun Issue.isImportant(): Boolean{
        return type == "Bug" &&
                (priority == "Major" || priority == "Critical")
    }

    }