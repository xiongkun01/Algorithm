public class Singleton {
	//此处的volatile必须要加，否则会因为指令重排序造成错误
	private volatile static Singleton instance = null;

	private Singleton() {}

	public static Singleton newInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}

class Singleton02 {

	private Singleton02() {}

	static class SingletonHolder {
		private static final Singleton02 instance = new Singleton02();
	}

	public static Singleton02 newInstance() {
		return SingletonHolder.instance;
	}

}