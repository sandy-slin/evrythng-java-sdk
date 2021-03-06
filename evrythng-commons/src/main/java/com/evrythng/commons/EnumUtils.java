/*
 * (c) Copyright 2012 EVRYTHNG Ltd London / Zurich
 * www.evrythng.com
 */
package com.evrythng.commons;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for the enums.
 * 
 **/
public class EnumUtils {

	/**
	 * Creates an enum value from a string using a lookup map (usually created
	 * by {@link #createNames(Object[])}.
	 * 
	 * Typical implementation:
	 * 
	 * <pre>
	 * public static MyEnum fromString(String name) {
	 * 	return EnumUtils.fromString(names, name);
	 * }
	 * </pre>
	 * 
	 * @return The enum value corresponding to the name. If the name is
	 *         <code>null</code>, returns <code>null</code>.
	 * @throw {@link IllegalArgumentException} if the name is not
	 *        <code>null</code> and does not match any enum value.
	 */
	public static <E> E fromString(Map<String, E> names, String name) {
		if (name == null) {
			return null;
		}
		E t = names.get(name);
		if (t == null) {
			throw new IllegalArgumentException("Invalid enum value.");
		}
		return t;
	}

	/**
	 * Creates a lookup map for the enum names, intended for use with the
	 * {@link #fromString(Map, String)} method. It uses the {@link #toString()}
	 * method to build the lookup map. This is intended to be used in a static
	 * initializer.
	 * 
	 * <pre>
	 * private static Map&lt;String, MyEnum&gt; names;
	 * static {
	 * 	names = EnumUtils.createNames(values());
	 * }
	 * </pre>
	 * 
	 * @param values
	 *            The enum values, as provided by <code>values()</code>.
	 */
	public static <E> Map<String, E> createNames(E[] values) {
		Map<String, E> names = new HashMap<String, E>();
		for (E t : values) {
			names.put(t.toString(), t);
		}
		return names;
	}
}
