(ns rmi-clojure.client
  (:import (java.rmi.registry LocateRegistry)))

(defn rmi-registry [] (LocateRegistry/getRegistry "127.0.0.1"))

(defn hello-world []
  (let [hello (.lookup (LocateRegistry/getRegistry) "olarmi")]
    (println (.sayHello hello))))

(hello-world)
