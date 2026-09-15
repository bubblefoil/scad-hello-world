# SCAD Hello World project

Trying to script a CAD file for a 2D object by SCAD Clojure wrapper.

## Usage

Search for SCAD Clojure.

## Lamination disc generator

A parametric generator for laminated disc plates: a ring with coil slots around
the bore, an alignment notch on the outer rim, and a per-plate skew angle so a
stack keyed to a single jig pin comes out helical.

It previews the selected plate live and exports **SVG** or **DXF (R12)** for
laser cutting — a single plate, or the whole stack nested on one sheet. Layer
`CUT` (black) is cut, layer `ENGRAVE` (red) is engraved. All dimensions in mm.

👉 **[Open the generator](https://claude.ai/artifact/8ab9ANkzA3UooF4kixh7gS)**

Source: [`docs/index.html`](docs/index.html) — a single self-contained file with
no build step and no dependencies. Download it and open it in a browser to run
it offline; it detects its host and saves exports either way.

### Self-hosting on GitHub Pages

`docs/index.html` is laid out to be served straight from Pages. To turn it on:
**Settings → Pages → Source: _Deploy from a branch_ → branch `main`, folder
`/docs`**. The page is then served at
`https://bubblefoil.github.io/scad-hello-world/`.
