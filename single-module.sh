#!/bin/bash
mvn archetype:generate \
    -DarchetypeGroupId=org.dominokit.domino.archetypes \
    -DarchetypeArtifactId=domino-gwt-single-module-archetype \
    -DarchetypeVersion=1.0-rc.5-SNAPSHOT \
    -DarchetypeParentGroupId=org.dominokit.domino \
    -DarchetypeParentArtifactId=domino-ui-demo \
    -DarchetypeParentVersion=1.0-SNAPSHOT \
    -DgroupId=org.dominokit.domino \
    -DartifactId=$1 \
    -Dmodule=${1^} \
    -Dsubpackage=$1

