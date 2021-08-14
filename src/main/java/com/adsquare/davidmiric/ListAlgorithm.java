package com.adsquare.davidmiric;

import java.util.List;
import java.util.Optional;

public class ListAlgorithm {

	public static Optional<Integer> findSecondMaxFrom(List<Integer> list) {
		if (list == null || list.isEmpty()) {
			return Optional.empty();
		}
		Integer firstMax = null;
		Integer secondMax = null;

		for (Integer number : list) {
			if (firstMax == null) {
				firstMax = number;
			} else if (secondMax == null) {
				if (!firstMax.equals(number)) {
					secondMax = number;
				}
			} else if (number > firstMax) {
				secondMax = firstMax;
				firstMax = number;
			} else if (number > secondMax) {
				secondMax = number;
			}
		}
		return Optional.ofNullable(secondMax);
	}
}
