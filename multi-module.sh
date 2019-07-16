#!/bin/bash

camel_case() {
    IFS=- read -ra str <<<"$1"
    local s="${str[@]^}"
    echo ${s// /''}
}

module=$(camel_case $1)

mvn archetype:generate \
    -DarchetypeGroupId=org.dominokit.domino.archetypes \
    -DarchetypeArtifactId=domino-gwt-module-archetype \
    -DarchetypeVersion=1.0-rc.5-SNAPSHOT \
    -DarchetypeParentGroupId=org.dominokit.domino \
    -DarchetypeParentArtifactId=domino-ui-demo \
    -DarchetypeParentVersion=1.0-SNAPSHOT \
    -DgroupId=org.dominokit.domino \
    -DartifactId=$1 \
    -Dmodule=${module} \
    -Dsubpackage=${1//-/''}
