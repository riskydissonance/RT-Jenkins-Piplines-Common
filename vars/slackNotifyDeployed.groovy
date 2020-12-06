#!/usr/bin/env groovy

def call(String repo){
    slackNotify("${env.STACK_PREFIX} Deployed ${JOB_NAME} for ${params.ProjectID} to https://artifactory.jmpesp.local/engagements/${params.ProjectID}/${JOB_NAME}/")
}
