import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.student.itpmlabs.Alien;
import org.student.itpmlabs.AlienRepository;
import static org.junit.Assert.*;

import java.util.List;

@RunWith(JUnit4.class)
public class AlienRepositoryTest {

    @Test
    public void getAllTest() {
        List<Alien> aliens = AlienRepository.getAll();
        assertNotNull(aliens);
        assertTrue(aliens.size() > 0);
        String name = aliens.get(0).getAname();
        assertNotNull(name);
        assertTrue(name.length() > 0);
    }
}
