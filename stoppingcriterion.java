// STAR-CCM+ macro: meshandrun.java
// Written by STAR-CCM+ 12.04.01
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;

public class stoppingcriterion extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PhysicalTimeStoppingCriterion physicalTimeStoppingCriterion_0 = 
      ((PhysicalTimeStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Physical Time"));

    physicalTimeStoppingCriterion_0.getMaximumTime().setValue(76.0);

    simulation_0.getSimulationIterator().run();
  }
}
