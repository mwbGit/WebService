package com.i360r.oas.data.dao;

import com.alibaba.fastjson.JSON;
import com.mwb.web.framework.model.Bool;
import com.mwb.web.framework.util.DateTimeUtility;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CourseTest extends AbstractPersistenceTest {

	/*
	 * util
	 */

	public static void printJSON(Object obj) {
		System.out.println(JSON.toJSONStringWithDateFormat(obj, "yyyy-MM-dd HH:mm:ss.SSS"));
	}

	public <T> List<T> newList(Class<T> cla, int size)
			throws InstantiationException, IllegalAccessException, ParseException {
		List<T> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			list.add(newInstance(cla));
		}
		return list;
	}

	public <T> T newInstance(Class<T> cla) throws InstantiationException, IllegalAccessException, ParseException {
		Date start = DateTimeUtility.parseYYYYMMDD("2017-1-1");
		Date end = DateTimeUtility.parseYYYYMMDD("2017-1-31");
		T o = cla.newInstance();
		Class<?> clazz = cla;
		while (clazz != Object.class) {
			for (Field field : clazz.getDeclaredFields()) {
				field.setAccessible(true);

				if (field.getName().equals("serialVersionUID")) {
					continue;
				}

				if (field.getType() == Integer.class) {
					field.set(o, Integer.valueOf(new Random().nextInt(10)));
				} else if (field.getType() == int.class) {
					field.set(o, new Random().nextInt(5558));
				} else if (field.getType() == Long.class) {
					field.set(o, Long.valueOf(new Random().nextInt(1000)));
				} else if (field.getType() == long.class) {
					field.set(o, new Random().nextInt(1000));
				} else if (field.getType() == Date.class) {
					long result = start.getTime() + (long) ((end.getTime() - start.getTime()) * Math.random());
					field.set(o, new Date(result));
				} else if (field.getType() == Bool.class) {
					if (Math.random() >= 0.5) {
						field.set(o, Bool.Y);
					} else {
						field.set(o, Bool.N);
					}
				} else if (field.getType() == Boolean.class || field.getType() == boolean.class) {
					field.set(o, new Random().nextBoolean());
				} else if (field.getType() == BigDecimal.class) {
					field.set(o, BigDecimal.valueOf(new Random().nextInt(100)));
				} else if (field.getType() == String.class) {
					String str = field.getName();
					str = str.length() >= 5 ? str.substring(0, 5) : str;
					field.set(o, str + new Random().nextInt(10));
				} else if (Enum.class.isAssignableFrom(field.getType())) {
					System.out.println(field.getType());
				}
			}
			clazz = clazz.getSuperclass();
		}

		return o;
	}
}
