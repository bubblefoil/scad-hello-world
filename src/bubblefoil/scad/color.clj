(ns bubblefoil.scad.color
  (:require [com.evocomputing.colors :as c]))

(defn f-rgba
  "Returns color as float RGBA vector"
  [color]
  (into []
        (map #(/ % 255.0) (:rgba color))))

(defn html
  [color-name]
  (f-rgba (c/create-color color-name)))

(defn hsv
  ([h s v]
   (hsv h s v 255))
  ([h s v a]
   (f-rgba (c/create-color {:h h :s s :l v :a a}))))