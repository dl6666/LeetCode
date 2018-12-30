package myleetcode;

public class ReadAnyBits {

	public ReadAnyBits() {
		this.buf = new char[size];
		this.index = 0;
	}
	private int size = 4096;
	private int index;
	private char[] buf;
	public void readAnyBytes(char[] buf, int n) {
		if (buf == null || buf.length == 0) return;
		int i = 0;
		n %= buf.length;
		while (i < n) {
			if (index >= size) {
				 read4K(buf);
				 index = 0;
			}
			buf[i++] = this.buf[index++];
		}
	}
	private void read4K(char[] buf) {
		
	}
}
