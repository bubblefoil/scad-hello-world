(ns bubblefoil.scad.toolbox
  (:require [scad-clj.model :as m]))

(defn mirrored-h [shape]
  (m/union shape (m/mirror [1 0 0] shape)))

(defn mirrored-v [shape]
  (m/union shape (m/mirror [0 1 0] shape)))

(defn smooth-circle
  "Creates a circle with segment length 0.1"
  [r]
  (m/with-fs 0.1 (m/circle r)))

(defn drill [d x y shape]
  (m/difference shape
                (->> (smooth-circle (/ d 2))
                     (m/translate [x y]))))