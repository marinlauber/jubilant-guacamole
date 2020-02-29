Define a custom field-function `tools.field functions.new`
```
(${WallDistance} < 0.01 && $${Position}[2] < 0.) ? 1. : 0.
```
set VOF replacement in `Continua.Physics.MultiphaseInteraction.PhaseInteractions.Model.VOFPhaseReplacemment`. Set method to `Field Function` in Phase replacement volume fraction limit, use your custom field function.

Set the phase interaction in `VOF_VOF phase replacement`. Primary phase: Air, Secondary phase: Water.
