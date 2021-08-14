import com.adsquare.davidmiric.ListAlgorithm;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ListAlgorithmTest {

	@Test
	public void testSecondMaxWhenNullListReturnEmpty() {
		// given
		List<Integer> list = null;
		// when
		var result = ListAlgorithm.findSecondMaxFrom(list);
		// then
		assertTrue(result.isEmpty());
	}

	@Test
	public void testSecondMaxWhenEmptyListReturnEmpty() {
		// given
		List<Integer> list = List.of();
		// when
		var result = ListAlgorithm.findSecondMaxFrom(list);
		// then
		assertTrue(result.isEmpty());
	}

	@Test
	public void testSecondMaxWhenOneValueInListThenReturnEmpty() {
		// given
		List<Integer> list = List.of(1, 1);
		// when
		var result = ListAlgorithm.findSecondMaxFrom(list);
		// then
		assertTrue(result.isEmpty());
	}

	@Test
	public void testSecondMaxWhenMoreElementsThenReturnSecondHighest() {
		// given
		var list = List.of(5, -4, 12, 0, -1, 14);
		// when
		var result = ListAlgorithm.findSecondMaxFrom(list);
		// then
		assertFalse(result.isEmpty());
		assertEquals(12, result.get().intValue());
	}
}
