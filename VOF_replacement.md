## Star-CCM+ tricks and tips


### VOF Replacement (Numerical vetilation)

Define a custom field-function `tools.field functions.new`, be very careful that this does not interfere with the free-surface, otherwise you are in for a bad time!

```
(${WallDistance} < 0.01 && $${Position}[2] < -0.1) ? 1. : 0.
```

set VOF replacement in 

```
Continua.Physics.MultiphaseInteraction.PhaseInteractions.Model.VOFPhaseReplacement
```

Set method to `Field Function` in phase replacement volume fraction limit, use your custom field function.

Set the phase interaction in `VOF_VOF phase replacement`. Primary phase: Air, Secondary phase: Water.


### Dynamic Pressure Coefficient

Custom scalar field function, by default StarCCM uses atmospheric pressure, we need to remove that as well as the hydrostatic pressure, which must be corrected because of the two phase.
```
(${AbsolutePressure} - 101325.0 + $${Postion}[2] * 9.81 * (${DensityWater}*${VolumeFractionWater} + ${DensityAir}*${VolumeFractionAir})) / (0.5*{DensityWater}*$${VelocityWave0}[0]*$${VelocityWave0}[0])
```
