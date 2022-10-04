(ns rmi-clojure.client
  (:import (java.rmi.registry LocateRegistry)))

(def rmi-registry (LocateRegistry/getRegistry "127.0.0.1"))

(defn hello-world []
  (let [hello (.lookup rmi-registry "olarmi")]
    (println (.sayHello hello))))

(hello-world)
