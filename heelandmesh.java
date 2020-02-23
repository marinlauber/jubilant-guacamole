// STAR-CCM+ macro: heelandmesh.java
// Written by STAR-CCM+ 14.04.013
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.meshing.*;

public class heelandmesh extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    Units units_1 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    CadPart cadPart_0 = 
      ((CadPart) simulation_0.get(SimulationPartManager.class).getPart("hull_surfaces"));

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    CartesianCoordinateSystem cartesianCoordinateSystem_0 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("hull-CSys"));

    simulation_0.get(SimulationPartManager.class).rotateParts(new NeoObjectVector(new Object[] {cadPart_0}),
                     new DoubleVector(new double[] {1.0, 0.0, 0.0}),
                     new NeoObjectVector(new Object[] {units_1, units_1, units_1}), HEEL_ANGLE(RAD), cartesianCoordinateSystem_0);

    simulation_0.get(SimulationPartManager.class).rotateParts(new NeoObjectVector(new Object[] {cadPart_0}),
                     new DoubleVector(new double[] {0.0, 1.0, 0.0}),
                     new NeoObjectVector(new Object[] {units_1, units_1, units_1}), TRIM_ANGLE(RAD), cartesianCoordinateSystem_0);

    simulation_0.get(SimulationPartManager.class).translateParts(new NeoObjectVector(new Object[] {cadPart_0}),
                     new DoubleVector(new double[] {0.0, 0.0, HEAVE(m)}),
                     new NeoObjectVector(new Object[] {units_1, units_1, units_1}), cartesianCoordinateSystem_0);
    
    MeshPipelineController meshPipelineController_0 = 
      simulation_0.get(MeshPipelineController.class);

    meshPipelineController_0.generateVolumeMesh();

    simulation_0.getSimulationIterator().run();
  }
}
