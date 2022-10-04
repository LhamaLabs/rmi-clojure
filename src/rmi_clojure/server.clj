(ns rmi-clojure.server
  (:import (java.rmi.registry LocateRegistry)
           (java.rmi.server UnicastRemoteObject)))

;; Registry server
(def rmi-registry (LocateRegistry/createRegistry 1099))

(defn stop-rmi-registry [](UnicastRemoteObject/unexportObject rmi-registry true))

;; function
(defn hello-server []
  (proxy [rmi_clojure.iRemoteHelloWorld] []
    (sayHello [] "Hello, World!")))

(def skeleton
  (UnicastRemoteObject/exportObject (hello-server) 0))

(defn register-server []
  (.rebind (LocateRegistry/getRegistry) "olarmi" skeleton))

(register-server)