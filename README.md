# SCAD Hello World project

Trying to script a CAD file for a 2D object by SCAD Clojure wrapper.

## Usage

Search for SCAD Clojure.

## Lamination disc generator

A parametric generator for laminated disc plates: a ring with coil slots around
the bore, optional alignment tabs on the outer rim, and a per-plate skew angle
so a stack keyed to a single jig pin comes out helical.

Alignment tabs stand proud of the rim in pairs, with the key riding in the gap
between each pair, so the yoke keeps full cross-section — a notch cut into the
rim would take roughly 20% of it at the default dimensions and saturate there.
Tab pairs default to 0. Every plate also carries an engraved datum tick, which
removes no material and indexes the plate when no tabs are cut.

It previews the selected plate live and exports **SVG** or **DXF (R12)** for
laser cutting — a single plate, or the whole stack nested on one sheet. Layer
`CUT` (black) is cut, layer `ENGRAVE` (red) is engraved. All dimensions in mm.

👉 **[Open the generator](https://claude.ai/artifact/8ab9ANkzA3UooF4kixh7gS)**

Source: [`docs/index.html`](docs/index.html) — a single self-contained file with
no build step and no dependencies. Download it and open it in a browser to run
it offline; it detects its host and saves exports either way.

### GitHub Pages

`.github/workflows/pages.yml` publishes `docs/` to
<https://bubblefoil.github.io/scad-hello-world/> on every push to `main` that
touches it. The workflow calls `configure-pages` with enablement, so the first
successful run switches Pages on by itself.

That call needs a write-capable workflow token. If the run fails there, set
**Settings → Actions → General → Workflow permissions** to _Read and write_, or
switch Pages on by hand under **Settings → Pages**.
