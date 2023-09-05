package inner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Exceptions.userDefinedException;

public class COllections {

	public static void main(String[] args) throws Exception {
		try {
			List<Object[]> listofobject = new ArrayList<Object[]>();
			listofobject.add(new Object[] { "A", "333324", "3g34g4t4" });
			listofobject.add(new Object[] { "A", "333324", "3g34g4t4" });
			listofobject.add(new Object[] { "Z", "FOR Z ", "3g34g4t4" });
			listofobject.add(new Object[] { "Z", "FOR Z ", "3g34g4t4" });
			listofobject.add(new Object[] { "Z", "FOR Z ", "3g34g4t4" });
			listofobject.add(new Object[] { "T", "FOR T", "3g34g4t4" });
			listofobject.add(new Object[] { "T", "FOR T", "3g34g4t4" });
			Comparator<Object[]> listcompare = (o1, o2) -> {
				return (o1[0].toString()).compareTo(o2[0].toString());
			};
			listofobject.sort(listcompare);
			listofobject.forEach(i -> System.out.println(Arrays.toString(i)));
//	System.out.println(Arrays.toString(listofobject.toArray()));
			Integer vahhd = Collections.frequency(
					listofobject.stream().map(s -> s[0].toString()).collect(Collectors.toList()),
					listofobject.get(0)[0].toString());
			System.out.println(vahhd);

//			Consumer<List<Object[]>> custom = t -> {
//				List<String> finalColumnElement = listofobject.stream().map(s -> s[0].toString())
//						.collect(Collectors.toList());
//				System.out.println(finalColumnElement);
//				Function<String, Integer> returnCountOfElement = (ts) -> {
//					return Collections.frequency(finalColumnElement, ts);
//				};
//				finalColumnElement.forEach(s -> {
//					 
//						System.out.println(returnCountOfElement.apply(s));
//						if (returnCountOfElement.apply(s) > 1) {
//							throw new RuntimeException("Dublicate record found "+ s);
//						
//			        }
//					
//				});
//			};
//			custom.accept(listofobject);
//			listofobject.forEach(x -> {
//				try {
//
//					if (Collections.frequency(
//							listofobject.stream().map(s -> s[0].toString()).collect(Collectors.toList()), x[0]) > 1) {
//						throw new userDefinedException(" dublicate record of " + x[0]);
//					}
//				} catch (Exception e) {
//					throw new IllegalArgumentException(e.getMessage());
//					// throw new userDefinedException("");
//				}
//			});

			listofobject.sort(new Comparator<Object[]>() {

				@Override
				public int compare(Object[] o1, Object[] o2) {
					return (o1[0].toString()).compareTo(o2[0].toString());
				}
			});
			;

			BiConsumer<List<Object[]>, Integer> usingMap = (t, u) -> {
				try {
					Map<Object, List<Object[]>> finalMap = listofobject.stream()
							.collect(Collectors.groupingBy(x -> new String(x[u].toString())));
					System.out.println("before");
					finalMap.get("T").forEach(i -> System.out.println(Arrays.toString(i)));
					System.out.println("after");
					t.set(6, new Object[] { "T", "FOR T", "new" });
					finalMap.get("T").forEach(i -> System.out.println(Arrays.toString(i)));
					if (finalMap.size() > 1) {
						throw new userDefinedException(" dublicate record of "
								+ finalMap.entrySet().stream().filter(ss -> ss.getValue().size() > 1)
										.map(e -> e.getKey().toString()).collect(Collectors.joining(",")));
					}
				} catch (userDefinedException e2) {
					System.out.println(e2.getMessage());
				}
			};
			usingMap.accept(listofobject, 0);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

}
