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
Tab pairs default to 0. Each tab root can be scored with a pair of cuts so the
tab is held by a small web and snaps off by hand — after the stack is bonded and
before it is wound, never by grinding a finished stator, which smears metal
across the lamination edges and shorts them. A snap web of 0 leaves the roots
solid, for tabs meant to stay on and sit in housing keyways as torque reaction
keys. Every plate also carries an engraved datum tick, which removes no material
and indexes the plate when no tabs are cut.

It previews the selected plate live and exports **SVG** or **DXF (R12)** for
laser cutting — a single plate, or the whole stack nested on one sheet. Layer
`CUT` (black) is cut, layer `ENGRAVE` (red) is engraved. All dimensions in mm.

👉 **[Open the generator](https://bubblefoil.github.io/scad-hello-world/)** —
opens on a phone, no sign-in, exports download normally.

Also published as a [claude.ai artifact](https://claude.ai/artifact/8ab9ANkzA3UooF4kixh7gS).
Saving files there needs a signed-in viewer, because the save runs as the viewer;
signed-out visitors get the file text to copy instead.

Source: [`docs/index.html`](docs/index.html) — a single self-contained file with
no build step and no dependencies. Download it and open it in a browser to run
it offline; it detects its host and saves exports either way.

### GitHub Pages

Pages is set to **Settings → Pages → Source: _Deploy from a branch_ → `main` /
`/docs`**, so GitHub's own builder redeploys the site on every push to `main`
that touches `docs/`. No workflow is involved, and none should be added: an
`actions/deploy-pages` workflow conflicts with branch-source Pages and fails.
