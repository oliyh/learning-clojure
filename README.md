learning-clojure
================

Learning materials for Clojure

###Pre-requisites
* A sense of adventure
* [Intellij](http://www.jetbrains.com/idea/free_java_ide.html)

###Install Leiningen
[Leiningen](http://leiningen.org/) is *the* build tool for Clojure. 
* Follow the instructions to download it from the page.
* Afterwards, run `lein self-install` to let it bootstrap itself.

###Install the La Clojure and Leiningen plugins for Intellij
* Open the Settings dialogue (Ctrl + Alt + S) and search for `plugin`. Press the `Browse repositories` button.
* Search for `La Clojure`. Double click on the La Clojure plugin to install
* Search for `Leiningen`. Select and install the Leiningen plugin
* Restart Intellij
* Open the Settings dialogue again
* Search for `Leiningen`
* Point the Leiningen executable to where you installed Leiningen. The rest should fill in automatically
 
###Hello World
* Either use Intellij to check out this project (VCS - Checkout from version control - Github) or use the command line.
  `git clone https://github.com/oliyh/learning-clojure`
* In Intellij, File - Open - project.clj
* It should be recognised as a Clojure project, and Leiningen should import the libraries
* Start the REPL - Tools > Start Clojure Console
* You should see a prompt that looks like `user=>`
* Type `(println "Hello World!")` and press enter
* If it worked you are now ready to code with Clojure!
