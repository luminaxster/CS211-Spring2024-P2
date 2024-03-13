package src.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.concurrent.TimeUnit;

import src.main.Bernard;
import src.main.Host;
import src.main.MazeLoop;
import src.main.MemorySnapshot;
import src.main.NarrativeLoop;
import src.main.SystemWhole;

// Author: Dr. Ford
public class FordTest{
    private final static String[] EMPTY_EMERGENCES ={};

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
    public void testBernardSimulationDiagnostics000(){
        // P2 emegences strings be like:
        String[] emergences ={"kind:Human"};
        // Using Bernard to get system wholes
        SystemWhole aSystemWhole = Bernard.analysis(emergences);
        // matching updateNarrativeLoops parameter types
        SystemWhole[] systemWholes = {aSystemWhole};
        // Getting a narrative
        NarrativeLoop narrativeLoop = new MazeLoop();
        // The part is in both, since it is the same array, it should have been added to the emulation list.
        narrativeLoop.updateNarrativeLoops(systemWholes,systemWholes);
        // Let's make sure of it, I can verify that via Host
        Host host = new Host(EMPTY_EMERGENCES, 0, false, true, true, narrativeLoop);
        // Tell me what you got host
        MemorySnapshot memorySnapshot = host.analyze();
        // Your simulated memories must have the aSystemWhole I created for you 
        assertTrue(memorySnapshot.getSimulationMemory().contains((Object)aSystemWhole));
    }  
}
