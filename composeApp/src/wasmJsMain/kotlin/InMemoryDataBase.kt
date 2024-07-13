import org.w3c.dom.DOMStringMap

class ConceptSkill(val skillName : String,
    val link : String)

class Project(
    val projectName : String,
    val aboutProject: String,
    val projectLink: String,
    val projectTechStack : List<String>,
    val thingsImplementedInProject : List<String>
)

object InMemoryDataBase {
    val conceptSkills = listOf(
        ConceptSkill("Kotlin QnA",
            "https://docs.google.com/document/d/1hqxzEJXMN5UVaaHzEZR9f7UktHy0zr6AsnKCvalSGyA/edit?usp=sharing"),
        ConceptSkill("OOPs","https://docs.google.com/document/d/17W8-YGcFjZaEMGN1DosF9V_VaYjsIZpyD--80lgu7rs/edit?usp=sharing"),
        ConceptSkill("Collection Framework","https://docs.google.com/document/d/19nALFdmWFIUxOrPH-9DqTa1Ahkcm97JiQy8s7DD078E/edit?usp=sharing"),
        ConceptSkill("Flow APIs","https://docs.google.com/document/d/1Dh_MGU6QH7vc8NsCevs0sHLJm6MprDbL__9QtyPRwmY/edit?usp=sharing"),
        ConceptSkill("Recycler View","https://docs.google.com/document/d/1ppHKzY3dDdJsppCz2UUyzqPv0xHqj8gqmsbCyUqQbgo/edit?usp=sharing"),
        ConceptSkill("Jetpack Navigation","https://docs.google.com/document/d/1DqgcmAyiNmBzZStBzHyVxgG9PSRX3XdOIjdwo6YeOLg/edit?usp=sharing"),
        ConceptSkill("View and Data Binding","https://docs.google.com/document/d/1LpQNKDKer_l8WE2YliTzpnpA8twE_aQiaD3k6NksTsc/edit?usp=sharing"),
        ConceptSkill("Security And Privacy","https://docs.google.com/document/d/1apDWaiWwsmp7nX79Bbw-me4iaz0cg4nQe2v0Qy4dHj8/edit?usp=sharing"),
        ConceptSkill("Exception Handling","https://docs.google.com/document/d/14mU9moYajcIT-88eKOsZMyfK-pCH3uRIlnLOvuRmikA/edit?usp=sharing"),
        ConceptSkill("Design Pattern","https://docs.google.com/document/d/1ahxkvfIfAzFMKOvMU6AotYv0aPSGx0gu_AifFP92ou8/edit?usp=sharing"),
        ConceptSkill("Coroutine","https://docs.google.com/document/d/1WSRNOnkPIBL_cdMJ85Nyd6cMvmAdjqeyRJzVvhhE9sg/edit?usp=sharing"),
        ConceptSkill("Jetpack Compose","https://docs.google.com/document/d/1Srv3dGO6HaSHeb1PNSNPdsQSekIBxYSZN5MARB71lpQ/edit?usp=sharing"),
        ConceptSkill("Side Effect","https://docs.google.com/document/d/1Zxsb9bWixnHUwMuYVKsCrsyAoN-v5lxFVBHJEgHlyxQ/edit?usp=sharing"),
        ConceptSkill("Firebase components","https://docs.google.com/document/d/1C5WttRr7IazAB3zWfu-ETSDq9CpaSH9BB0puQlNFOlY/edit?usp=sharing"),
        ConceptSkill("Android Architecture","https://docs.google.com/document/d/1YEvZ50cyZ0ipjEkBcncvdNUwyMq7-Fjun4sQYFrjqPU/edit?usp=sharing"),
        ConceptSkill("Android System Internal","https://docs.google.com/document/d/1zVwknOzp2fP4ZLJrQKQ12i_FZn88kAzbo0wqSX19V48/edit?usp=sharing"),
        ConceptSkill("Android Unit Testing","https://docs.google.com/document/d/1_jHN28-f7sgguhqMPW9Igrwuu0sxr8qFgpkO3uk3NkE/edit?usp=sharing"),
        ConceptSkill("Android Tools And Technologies","https://docs.google.com/document/d/1TKclo415LxXImveVD7P_1-qN5z1qFjKYFCa2bs1_r2g/edit?usp=sharing"),
        ConceptSkill("Application Components","https://docs.google.com/document/d/1EHDoZBM9IWrAZLLwDHIWzN2M8CWCDOEG-pukz6lgYUM/edit?usp=sharing"),
        ConceptSkill("Best Practices","https://docs.google.com/document/d/19edW7bCF3Sg2WmU-upabmNQK4hW6sN14Ua8CsKC1Pi8/edit?usp=sharing"),
        ConceptSkill("DI (Dependency Injection)","https://docs.google.com/document/d/1RC-EKBhzctDVPxnI32-b3TlwnEhFYzgrI0luGwEXOS0/edit?usp=sharing"),
        ConceptSkill("Git (Version Control)","https://docs.google.com/document/d/1tSgFVFSNY1EzVpvMVZKK9Zc9B9DUGhjyBzfiFhuv_5c/edit?usp=sharing"),
    )

    val projectList = listOf(
        Project(
            projectName = "MJetpack Compose",
            aboutProject = "Showcase the Material3 Components in",
            projectLink = "",
            projectTechStack = listOf("Jetpack Compose Navigation", "Clean Architecture"),
            thingsImplementedInProject = listOf(
                "- Studied and Used all the material3 Components",
                "- Jetpack Compose Navigation",
                "- Built for light and dark mode",
                "- Code sharing feature")
        ),
        Project(
            projectName = "RepnetV2.0",
            aboutProject = "Water Purifier Servicing Based project, I had created this project for organization and added lot of feature in the application.",
            projectLink = "",
            projectTechStack = listOf("Jetpack Navigation", "MVVM"),
            thingsImplementedInProject = listOf("- Developed an application from scratch using MVVM architecture and Jetpack Component",
                "- Used Google Map SDK, Networking Retrofit library and WorkManager to execute task in the background.",
                "- Implemented offline-first approach using Room database when device is in offline state.")
        ),
        Project(
            projectName = "Kratinn",
            aboutProject = "An IoT based application, used to start the system with WOL And Smart Devices.",
            projectLink = "",
            projectTechStack = listOf("MVVM", "Retrofit", "RecyclerView", "Authentication"),
            thingsImplementedInProject = listOf("- Setup WIFI devices with WOL and Smart IoT Devices",
                "- MQTT for sending signal to Smart device", "- Shown available system in the recycler view.")
        ),
        Project(
            projectName = "Vscan",
            aboutProject = "An scanner application, open source library had been used, " +
                    "image filtering and saving in external storage.",
            projectLink = "",
            projectTechStack = listOf("Kotlin", "External Storage", "Bitmap filtering"),
            thingsImplementedInProject = listOf("- Scan document with open source library",
                "- Filter bitmap and save in the external file storage", "- Generate PDF with scanned document.",
                "- Share the Scanned document or PDF on Social Media.")
        ),
        Project(
            projectName = "NetUtility",
            aboutProject = "An application which use broadcast and location to enable wifi and disable cellular connection and vice versa.",
            projectLink = "",
            projectTechStack = listOf("MVVM", "Broadcast Receivers", "Intents", "Permission Handling", "Location"),
            thingsImplementedInProject = listOf("- Receives the location updates and finds the target location",
                "- Turn on WIFI and disable cellular connection", "- Used Jetpack compose, Handled Side Effect")
        ),
        Project(
            projectName = "Coronis Health",
            aboutProject = "An application for hospital revenue demonstration using graphical representation view.",
            projectLink = "",
            projectTechStack = listOf("Flutter", "Dart", "Navigation", "Push Notification", "Provider", "http"),
            thingsImplementedInProject = listOf("- Integrated various chars like bar, stack bar, tableview etc",
                "- Used biometric authentication and pin setup for security",
                "- Used http networking library and provider state management solution")
        )
    )
}