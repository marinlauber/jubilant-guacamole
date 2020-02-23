// STAR-CCM+ macro: starccmgenerate.java
// Written by STAR-CCM+ 14.04.013
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.meshing.*;

public class starccmgenerate extends StarMacro {

  public void execute() {
    execute0();
  }

    private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PartImportManager partImportManager_0 = 
      simulation_0.get(PartImportManager.class);

    partImportManager_0.importCadPart(resolvePath("hull.igs"), "SharpEdges", 30.0, 2, 0.001, false, true, 1.0E-5, false, false, false, false);

    simulation_0.getSceneManager().createGeometryScene("Geometry Scene", "Outline", "Geometry", 1);

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    scene_0.initializeAndWait();

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_0.initialize();

    PartDisplayer partDisplayer_1 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getDisplayer("Geometry 1"));

    partDisplayer_1.initialize();

    SceneUpdate sceneUpdate_0 = 
      scene_0.getSceneUpdate();

    HardcopyProperties hardcopyProperties_0 = 
      sceneUpdate_0.getHardcopyProperties();

    //hardcopyProperties_0.setCurrentResolutionWidth(752);

    //hardcopyProperties_0.setCurrentResolutionHeight(574);

    scene_0.resetCamera();

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    //currentView_0.setInput(new DoubleVector(new double[] {-6.169531706843575, -2.443371752927983, 4.3090367682173465}), new DoubleVector(new double[] {-8.171702408162126, -27.03449273602178, 12.782441078784734}), new DoubleVector(new double[] {-0.054601410723132834, 0.32936770551939676, 0.9426216635044687}), 6.667704771847623, 0, 30.0);

    //currentView_0.setInput(new DoubleVector(new double[] {-6.207613404284985, -1.1985439598229135, 2.9946181952504536}), new DoubleVector(new double[] {-8.332389322508828, -27.29553041187547, 11.986901127275647}), new DoubleVector(new double[] {-0.054601410723132834, 0.32936770551939676, 0.9426216635044687}), 6.667704771847623, 0, 30.0);

    //currentView_0.setInput(new DoubleVector(new double[] {-5.448795957092665, -2.8063523521899802, 3.4715945490452262}), new DoubleVector(new double[] {16.11669535252369, -20.977364683614176, 7.733158148716103}), new DoubleVector(new double[] {-0.007385867225784937, 0.2197628572917076, 0.9755253638528871}), 6.667704771847623, 0, 30.0);

    //currentView_0.setInput(new DoubleVector(new double[] {-4.508625071734218, -0.19788578416783298, 3.173401110440284}), new DoubleVector(new double[] {17.809654253470846, -19.00319483148048, 7.583723389403147}), new DoubleVector(new double[] {-0.007385867225784937, 0.2197628572917076, 0.9755253638528871}), 6.667704771847623, 0, 30.0);

    //currentView_0.setInput(new DoubleVector(new double[] {-2.7400153677437338, -0.999507757807601, 2.243041232412576}), new DoubleVector(new double[] {11.095789676803543, -12.65751176384395, 4.977139069714956}), new DoubleVector(new double[] {-0.007385867225784937, 0.2197628572917076, 0.9755253638528871}), 6.667704771847623, 0, 30.0);


    //scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    CadPart cadPart_0 = 
      ((CadPart) simulation_0.get(SimulationPartManager.class).getPart("hull"));

    PartSurface partSurface_0 = 
      ((PartSurface) cadPart_0.getPartSurfaceManager().getPartSurface("Faces"));

    partDisplayer_0.getHiddenParts().addObjects(partSurface_0);

    partDisplayer_1.getHiddenParts().addObjects(partSurface_0);

    currentView_0.setInput(new DoubleVector(new double[] {-4.629182861804486, 0.6925496626803671, 1.0926171744536717}), new DoubleVector(new double[] {13.460578974247339, -6.936118823675169, 6.739486985785282}), new DoubleVector(new double[] {-0.14267496934971252, 0.3480340612004397, 0.9265614633500504}), 6.667704771847623, 0, 30.0);

    cadPart_0.splitPartSurfaceByPatch(partSurface_0, new IntVector(new int[] {2}), "Faces");

    currentView_0.setInput(new DoubleVector(new double[] {-4.629182861804486, 0.6925496626803671, 1.0926171744536717}), new DoubleVector(new double[] {13.460578974247339, -6.936118823675169, 6.739486985785282}), new DoubleVector(new double[] {-0.14267496934971252, 0.3480340612004397, 0.9265614633500504}), 6.667704771847623, 0, 30.0);

    cadPart_0.splitPartSurfaceByPatch(partSurface_0, new IntVector(new int[] {4}), "Faces");

    partDisplayer_1.getVisibleParts().addParts(partSurface_0);

    partDisplayer_1.getHiddenParts().addParts();

    partDisplayer_0.getVisibleParts().addParts(partSurface_0);

    partDisplayer_0.getHiddenParts().addParts();

    //scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.USE_DISPLAYER_PROPERTY);

    partSurface_0.setPresentationName("hull");

    PartSurface partSurface_1 = 
      ((PartSurface) cadPart_0.getPartSurfaceManager().getPartSurface("Faces 2"));

    partSurface_1.setPresentationName("deck");

    PartSurface partSurface_2 = 
      ((PartSurface) cadPart_0.getPartSurfaceManager().getPartSurface("Faces 3"));

    partSurface_2.setPresentationName("transom");

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    //scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    MeshPartFactory meshPartFactory_0 = 
      simulation_0.get(MeshPartFactory.class);

    SimpleBlockPart simpleBlockPart_0 = 
      meshPartFactory_0.createNewBlockPart(simulation_0.get(SimulationPartManager.class));

    simpleBlockPart_0.setDoNotRetessellate(true);

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    simpleBlockPart_0.setCoordinateSystem(labCoordinateSystem_0);

    simpleBlockPart_0.getCorner1().setCoordinateSystem(labCoordinateSystem_0);

    simpleBlockPart_0.getCorner1().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-64.0, -36.0, -24.0}));

    simpleBlockPart_0.getCorner2().setCoordinateSystem(labCoordinateSystem_0);

    simpleBlockPart_0.getCorner2().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {24.0, 36.0, 6.0}));

    simpleBlockPart_0.rebuildSimpleShapePart();

    simpleBlockPart_0.setDoNotRetessellate(false);

    SimpleBlockPart simpleBlockPart_1 = 
      meshPartFactory_0.createNewBlockPart(simulation_0.get(SimulationPartManager.class));

    simpleBlockPart_1.setDoNotRetessellate(true);

    simpleBlockPart_1.setCoordinateSystem(labCoordinateSystem_0);

    simpleBlockPart_1.getCorner1().setCoordinateSystem(labCoordinateSystem_0);

    simpleBlockPart_1.getCorner1().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-64.0, -36.0, -0.25}));

    simpleBlockPart_1.getCorner2().setCoordinateSystem(labCoordinateSystem_0);

    simpleBlockPart_1.getCorner2().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {24.0, 36.0, 0.25}));

    simpleBlockPart_1.rebuildSimpleShapePart();

    simpleBlockPart_1.setDoNotRetessellate(false);

    SimpleBlockPart simpleBlockPart_2 = 
      meshPartFactory_0.createNewBlockPart(simulation_0.get(SimulationPartManager.class));

    simpleBlockPart_2.setDoNotRetessellate(true);

    simpleBlockPart_2.setCoordinateSystem(labCoordinateSystem_0);

    simpleBlockPart_2.getCorner1().setCoordinateSystem(labCoordinateSystem_0);

    simpleBlockPart_2.getCorner1().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-30.0, -3.5999999999999934, -2.0}));

    simpleBlockPart_2.getCorner2().setCoordinateSystem(labCoordinateSystem_0);

    simpleBlockPart_2.getCorner2().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 3.6000000000000005, 0.0}));

    simpleBlockPart_2.rebuildSimpleShapePart();

    simpleBlockPart_2.setDoNotRetessellate(false);

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.USE_DISPLAYER_PROPERTY);

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    SimpleConePart simpleConePart_0 = 
      meshPartFactory_0.createNewConePart(simulation_0.get(SimulationPartManager.class));

    simpleConePart_0.setDoNotRetessellate(true);

    simpleConePart_0.setCoordinateSystem(labCoordinateSystem_0);

    simpleConePart_0.getStartCoordinate().setCoordinateSystem(labCoordinateSystem_0);

    simpleConePart_0.getStartCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-30.0, 0.0, 0.0}));

    simpleConePart_0.getStartRadius().setUnits(units_0);

    simpleConePart_0.getStartRadius().setValue(15.0);

    simpleConePart_0.getEndCoordinate().setCoordinateSystem(labCoordinateSystem_0);

    simpleConePart_0.getEndCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    simpleConePart_0.getEndRadius().setUnits(units_0);

    simpleConePart_0.getEndRadius().setValue(0.0);

    simpleConePart_0.getTessellationDensityOption().setSelected(TessellationDensityOption.Type.MEDIUM);

    simpleConePart_0.rebuildSimpleShapePart();

    simpleConePart_0.setDoNotRetessellate(false);

    SimpleConePart simpleConePart_1 = 
      meshPartFactory_0.createNewConePart(simulation_0.get(SimulationPartManager.class));

    simpleConePart_1.setDoNotRetessellate(true);

    simpleConePart_1.setCoordinateSystem(labCoordinateSystem_0);

    simpleConePart_1.getStartCoordinate().setCoordinateSystem(labCoordinateSystem_0);

    simpleConePart_1.getStartCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-48.0, 0.0, 0.0}));

    simpleConePart_1.getStartRadius().setUnits(units_0);

    simpleConePart_1.getStartRadius().setValue(30.0);

    simpleConePart_1.getEndCoordinate().setCoordinateSystem(labCoordinateSystem_0);

    simpleConePart_1.getEndCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {3.0, 0.0, 0.0}));

    simpleConePart_1.getEndRadius().setUnits(units_0);

    simpleConePart_1.getEndRadius().setValue(2.0);

    simpleConePart_1.getTessellationDensityOption().setSelected(TessellationDensityOption.Type.MEDIUM);

    simpleConePart_1.rebuildSimpleShapePart();

    simpleConePart_1.setDoNotRetessellate(false);
    
    PartSurface partSurface_3 = 
      ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface"));

    // Split domain for inlet and so on
    simpleBlockPart_0.getPartSurfaceManager().splitPartSurfacesByAngle(new NeoObjectVector(new Object[] {partSurface_3}), 89.0);

    // remane splitted surfaces
    partSurface_3.setPresentationName("outlet");
	
    PartSurface partSurface_4 = 
      ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface 6"));

    partSurface_4.setPresentationName("inlet");

    PartSurface partSurface_5 = 
      ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface 5"));

    partSurface_5.setPresentationName("right");

    PartSurface partSurface_6 = 
      ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface 4"));

    partSurface_6.setPresentationName("top");

    PartSurface partSurface_7 = 
      ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface 3"));

    partSurface_7.setPresentationName("bottom");

    PartSurface partSurface_8 = 
      ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface 2"));

    partSurface_8.setPresentationName("left");

    //  now define boolean operations, REMOVE HULL FROM DOMAIN
    SubtractPartsOperation subtractPartsOperation_0 = 
      (SubtractPartsOperation) simulation_0.get(MeshOperationManager.class).createSubtractPartsOperation(new NeoObjectVector(new Object[] {simpleBlockPart_0, cadPart_0}));

    subtractPartsOperation_0.getTargetPartManager().setQuery(null);

    subtractPartsOperation_0.getTargetPartManager().setObjects(simpleBlockPart_0);

    subtractPartsOperation_0.setPerformCADBoolean(false);

    subtractPartsOperation_0.setLinkOutputPartName(false);
    
    // intersect cone 1 and free surface
    IntersectPartsOperation intersectPartsOperation_0 = 
      (IntersectPartsOperation) simulation_0.get(MeshOperationManager.class).createIntersectPartsOperation(new NeoObjectVector(new Object[] {simpleBlockPart_1, simpleConePart_0}));

    intersectPartsOperation_0.setPerformCADBoolean(false);

    intersectPartsOperation_0.setLinkOutputPartName(false);

    // intersect cone 2 and free surface
    IntersectPartsOperation intersectPartsOperation_1 = 
      (IntersectPartsOperation) simulation_0.get(MeshOperationManager.class).createIntersectPartsOperation(new NeoObjectVector(new Object[] {simpleBlockPart_1, simpleConePart_1}));

    intersectPartsOperation_1.setPerformCADBoolean(false);

    intersectPartsOperation_1.setLinkOutputPartName(false);

    // execute all intersects
    subtractPartsOperation_0.execute();
    intersectPartsOperation_0.execute();
    intersectPartsOperation_1.execute();

    // detach resulting volumes
    MeshOperationPart meshOperationPart_0 = 
      ((MeshOperationPart) simulation_0.get(SimulationPartManager.class).getPart("Intersect"));

    meshOperationPart_0.detach();

    MeshOperationPart meshOperationPart_1 = 
      ((MeshOperationPart) simulation_0.get(SimulationPartManager.class).getPart("Intersect 2"));

    meshOperationPart_1.detach();

    MeshOperationPart meshOperationPart_2 = 
      ((MeshOperationPart) simulation_0.get(SimulationPartManager.class).getPart("Subtract"));
    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {meshOperationPart_2}), "OneRegionPerPart", null, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", null, RegionManager.CreateInterfaceMode.NONE);
  }
}
