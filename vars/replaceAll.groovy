#!/usr/bin/env groovy

@NoCPS
def call(String glob, String find, String replace){

   new File(".").eachDirRecurse(
      {
         dir ->
            dir.eachFileMatch(glob){
                  file ->
                     fileText = file.text;
                     fileText = fileText.replaceAll(find, replace)
                     file.write(fileText);
         }
      })
}
