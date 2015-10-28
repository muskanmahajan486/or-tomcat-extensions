# OR Tomcat Extensions

This projects contains extension to the Tomcat servlet container that are specific to Open Remote.

Currently, this only includes a specific Realm that is compatible with the legacy Beehive "users" schema.

---

    ./gradlew clean check build

The jar can be found in `build/libs/or-tomcat-extensions-1.0.0.jar`.
This jar should be copied to Tomcat's lib folder.