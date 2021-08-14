import com.adsquare.davidmiric.ListAlgorithm;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ListAlgorithmTest {

	private static final long MAXIMUM_TIME_IN_MS = 5000;

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

	@Test
	public void testSecondMaxWhenMillionElementsPerformance() {
		// given
		var list = createHugeList();
		// when
		var start = System.currentTimeMillis();
		var result = ListAlgorithm.findSecondMaxFrom(list);
		var end = System.currentTimeMillis();
		// then
		assertTrue((end - start) < MAXIMUM_TIME_IN_MS);
	}

	private List<Integer> createHugeList() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 200000000; i++) {
			list.add(-1000000 + ((int) (Math.random() * 2000000d)));
		}
		return list;
	}
}
