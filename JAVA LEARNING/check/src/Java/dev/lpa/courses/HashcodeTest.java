package Java.dev.lpa.courses;

import java.util.Objects;

public class HashcodeTest {
	private String r1;
	private String r2;
	private String r4;

	public String getR1() {
		return r1;
	}

	public void setR1(String r1) {
		this.r1 = r1;
	}

	public String getR2() {
		return r2;
	}

	public void setR2(String r2) {
		this.r2 = r2;
	}

	public String getR4() {
		return r4;
	}

	public void setR4(String r4) {
		this.r4 = r4;
	}

	public String getR3() {
		return r3;
	}

	public void setR3(String r3) {
		this.r3 = r3;
	}

	private String r3;

	@Override
	public int hashCode() {
		return Objects.hash(r1, r2, r3, r4);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashcodeTest other = (HashcodeTest) obj;
		return Objects.equals(r1, other.r1) && Objects.equals(r2, other.r2) && Objects.equals(r3, other.r3)
				&& Objects.equals(r4, other.r4);
	}

}
