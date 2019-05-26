package com.woowacourse.coordinate.domain;

import com.woowacourse.coordinate.domain.figure.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
	@Test
	void creat() {
		Point point = new Point(10, 10);
		assertThat(point).isEqualTo(new Point(10, 10));
	}

	@Test
	void validateRange() {
		assertThrows(IllegalArgumentException.class, () -> new Point(-1, 10));
		assertThrows(IllegalArgumentException.class, () -> new Point(10, -1));
		assertThrows(IllegalArgumentException.class, () -> new Point(5, 25));
		assertThrows(IllegalArgumentException.class, () -> new Point(25, 5));
	}

	@Test
	void calculateDistance() {
		assertThat(new Point(1, 1).calculateDistance(new Point(1, 3))).isEqualTo(2);
		assertThat(new Point(1, 1).calculateDistance(new Point(2, 2))).isEqualTo(1.414, offset(0.01));
	}

	@Test
	void calculateSlope() {
		assertThat(new Point(1, 1).calculateSlope(new Point(3, 3)).get()).isEqualTo(1);
		assertThat(new Point(1, 1).calculateSlope(new Point(5, 2)).get()).isEqualTo(0.25, offset(0.01));
		assertThat(new Point(1, 1).calculateSlope(new Point(5, 1)).get()).isEqualTo(0);
		assertThat(new Point(1, 1).calculateSlope(new Point(1, 6)).isPresent()).isFalse();
	}

	@Test
	void calculateAngle() {
		assertThat(new Point(6, 3).calculateAngle(new Point(9, 6), new Point(3, 6))).isEqualTo(90);
		assertThat(new Point(1, 1).calculateAngle(new Point(1, 5), new Point(7, 1))).isEqualTo(90);
	}
}
