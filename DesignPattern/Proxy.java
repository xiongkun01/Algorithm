public class Proxy {
	
	public static void main(String[] args) {
		ProxySubject proxy = new ProxySubject(new RealSubject());
		proxy.visit();
	}

	public interface Subject {
		void visit();
	}

	public class RealSubject implements Subject {
		private String name = "RealSubject";

		@Override
		public void visit() {
			System.out.println(name);
		}
	}

	public class ProxySubject implements Subject {
		private Subject Subject;

		public ProxySubject(Subject subject) {
			this.subject = subject;
		}

		@Override
		public void visit() {
			subject.visit();
		}
	}

	/****动态代理*****************/
	public class DynamicProxy implements InvocationHandler {
		private Object object;

		public DynamicProxy(Object object) {
			this.object = object;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			Object result = method.invoke(object, args);
			return result;
		}
	}

	public void dynamicProxy() {
		Subject realSubject = new RealSubject();
		DynamicProxy proxy = new DynamicProxy(realSubject);
		ClassLoader loader = realSubject.getClass().getClassLoader();
		Subject subject = (Subject) Proxy.newProxyInstance(classLoader, new  Class[]{Subject.class}, proxy);
		subject.visit();
	}

}