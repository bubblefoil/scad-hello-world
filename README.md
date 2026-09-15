# SCAD Hello World project

Trying to script a CAD file for a 2D object by SCAD Clojure wrapper.

## Usage

Search for SCAD Clojure.

## Lamination disc generator

A standalone browser tool for parametric laminated disc plates: a ring with coil
slots around the bore, an alignment notch on the outer rim, and a per-plate skew
angle so a stack keyed to a single jig pin comes out helical.

It previews the selected plate live and exports **SVG** or **DXF (R12)** for
laser cutting — a single plate, or the whole stack nested on one sheet. Layer
`CUT` (black) is cut, layer `ENGRAVE` (red) is engraved. All dimensions in mm.

👉 **[Open the generator](https://bubblefoil.github.io/scad-hello-world/)** — source: [`docs/index.html`](docs/index.html)

Single self-contained HTML file, no build step and no dependencies; it also runs
straight from disk by opening the file in a browser.
