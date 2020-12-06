#!/usr/bin/env groovy

def call(){
    // clean up our workspace
     deleteDir()

     // clean up tmp directory
     dir("${workspace}@tmp") {
          deleteDir()
     }

     // clean up script directory
     dir("${workspace}@script") {
          deleteDir()
     }

     // clean up libs directory
     dir("${workspace}@libs") {
          deleteDir()
     }
}
