package com.research.researchbuddy

class Constants {

    class WebServices {
        companion object {
            const val USE_WEB_SERVICES = true

            val SPRINGER_NATURE_BASE_PATH =
                    if (USE_WEB_SERVICES)
                       "http://api.springer.com/openaccess/"
                    else
                        ""

            val CORE_BASE_PATH =
                    if (USE_WEB_SERVICES)
                        "https://core.ac.uk:443/api-v2/articles/search/"
                    else
                        ""
        }
    }

    class App {
        companion object {
            const val SHARED_PREFS_NAME = "app_shared_prefs"
        }
    }

    class Intents {
        companion object {

        }
    }

    class ApiKeys {
        companion object {
            const val SPRINGER_NATURE_KEY = "cd85431633c69e4ae13b57e228b031f6"
            const val CORE_KEY = "nyVNY7w1dTkP4cesGOEIF0aBqKrZ2v9i"
        }
    }

}