package com.evrythng.java.wrapper.service;

import com.evrythng.java.wrapper.ApiManager;
import com.evrythng.java.wrapper.core.EvrythngApiBuilder.Builder;
import com.evrythng.java.wrapper.core.EvrythngServiceBase;
import com.evrythng.java.wrapper.exception.EvrythngClientException;
import com.evrythng.java.wrapper.mapping.ActionDeserializer;
import com.evrythng.java.wrapper.mapping.EvrythngJacksonModule;
import com.evrythng.thng.resource.model.store.Location;
import com.evrythng.thng.resource.model.store.Property;
import com.evrythng.thng.resource.model.store.Redirector;
import com.evrythng.thng.resource.model.store.Thng;
import com.evrythng.thng.resource.model.store.action.Action;
import com.evrythng.thng.resource.model.store.action.CustomAction;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collections;
import java.util.List;

/**
 * Service wrapper for the {@code /thngs} endpoint of the EVRYTHNG Engine API.
 *
 * @author Pedro De Almeida (almeidap)
 */
public class ThngService extends EvrythngServiceBase {

	public static final String PATH_THNGS = "/thngs";
	public static final String PATH_THNG = PATH_THNGS + "/%s";
	public static final String PATH_THNG_PROPERTIES = PATH_THNG + "/properties";
	public static final String PATH_THNG_PROPERTY = PATH_THNG_PROPERTIES + "/%s";
	public static final String PATH_THNG_LOCATION = PATH_THNG + "/location";
	public static final String PATH_THNG_REDIRECTOR = PATH_THNG + "/redirector";
	public static final String PATH_THNG_REDIRECTOR_QR = PATH_THNG_REDIRECTOR + "/qr";
	public static final String PATH_THNG_ACTIONS = PATH_THNG + "/actions";
	public static final String PATH_THNG_TYPED_ACTIONS = PATH_THNG_ACTIONS + "/%s";
	public static final String PATH_THNG_TYPED_ACTION = PATH_THNG_TYPED_ACTIONS + "/%s";

	protected ActionDeserializer deserializer;

	public ThngService(final ApiManager apiManager, final EvrythngJacksonModule evrythngJacksonModule) {

		super(apiManager);
		deserializer = evrythngJacksonModule.getActionDeserializer();
	}

	/* ***** Thng ***** */

	/**
	 * Creates a new {@link Thng}.
	 * <p>
	 * POST {@value #PATH_THNGS}
	 *
	 * @param thng {@link Thng} instance
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Thng> thngCreator(final Thng thng) throws EvrythngClientException {

		return post(PATH_THNGS, thng, new TypeReference<Thng>() {

		});
	}

	/**
	 * Retrieves the lst updates {@link Thng} resources.
	 * <p>
	 * GET {@value #PATH_THNGS}
	 *
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<List<Thng>> thngsReader() throws EvrythngClientException {

		return get(PATH_THNGS, new TypeReference<List<Thng>>() {

		});
	}

	/* ***** /thngs/{id} ***** */

	/**
	 * Retrieves the referenced {@link Thng}.
	 * <p>
	 * GET {@value #PATH_THNG}
	 *
	 * @param thngId thng id
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Thng> thngReader(final String thngId) throws EvrythngClientException {

		return get(String.format(PATH_THNG, thngId), new TypeReference<Thng>() {

		});
	}

	/**
	 * Updates the referenced {@link Thng}.
	 * <p>
	 * PUT {@value #PATH_THNG}
	 *
	 * @param thngId thng id
	 * @param thng   {@link Thng} instance
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Thng> thngUpdater(final String thngId, final Thng thng) throws EvrythngClientException {

		return put(String.format(PATH_THNG, thngId), thng, new TypeReference<Thng>() {

		});
	}

	/**
	 * Batch update a list of {@link Thng}. Select the {@link Thng}s to update
	 * using query parameters
	 * ?ids or ?filter.
	 * <p>
	 * PUT {@value #PATH_THNGS}
	 *
	 * @param thng {@link Thng} instance
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Long> thngsUpdater(final Thng thng) throws EvrythngClientException {

		return putMultiple(PATH_THNGS, thng);
	}

	/**
	 * Deletes the referenced {@link Thng}.
	 * <p>
	 * DELETE {@value #PATH_THNG}
	 *
	 * @param thngId thng id
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Boolean> thngDeleter(final String thngId) throws EvrythngClientException {

		return delete(String.format(PATH_THNG, thngId));
	}

	/**
	 * Bulk delete some thngs. Select the {@link Thng}s to delete using query
	 * parameters ?ids or ?filter.
	 * <p>
	 * DELETE {@value #PATH_THNGS}
	 *
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Long> thngsDeleter() throws EvrythngClientException {

		return deleteMultiple(PATH_THNGS);
	}

	/* ***** /thngs/{id}/properties ***** */

	/**
	 * Creates a new {@link Property} on the referenced {@link Thng}.
	 * <p>
	 * PUT {@value #PATH_THNG_PROPERTIES}
	 *
	 * @param thngId   thng id
	 * @param property {@link Property} instance
	 * @return a preconfigured {@link Builder}
	 * @see #propertiesCreator(String, List)
	 */
	public Builder<List<Property>> propertiesCreator(final String thngId, final Property property) throws EvrythngClientException {

		return propertiesCreator(thngId, Collections.singletonList(property));
	}

	/**
	 * Creates multiple {@link Property} resources on the referenced
	 * {@link Thng}.
	 * <p>
	 * PUT {@value #PATH_THNG_PROPERTIES}
	 *
	 * @param thngId     thng id
	 * @param properties list of {@link Property} instances
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<List<Property>> propertiesCreator(final String thngId, final List<Property> properties) throws EvrythngClientException {

		return put(String.format(PATH_THNG_PROPERTIES, thngId), properties, new TypeReference<List<Property>>() {

		});
	}

	/**
	 * Retrieves the last updated {@link Property} resources from the referenced
	 * {@link Thng}.
	 * <p>
	 * GET {@value #PATH_THNG_PROPERTIES}
	 *
	 * @param thngId thng id
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<List<Property>> propertiesReader(final String thngId) throws EvrythngClientException {

		return get(String.format(PATH_THNG_PROPERTIES, thngId), new TypeReference<List<Property>>() {

		});
	}

	/**
	 * Deletes all {@link Property} resources from the referenced {@link Thng}.
	 * <p>
	 * DELETE {@value #PATH_THNG_PROPERTIES}
	 *
	 * @param thngId thng id
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Boolean> propertiesDeleter(final String thngId) throws EvrythngClientException {

		return delete(String.format(PATH_THNG_PROPERTIES, thngId));
	}

	/* ***** /thngs/{id}/properties/{key} ***** */

	/**
	 * Retrieves the last values of the {@link Property} named {@code key} from
	 * the referenced {@link Thng}.
	 * <p>
	 * GET {@value #PATH_THNG_PROPERTY}
	 *
	 * @param thngId thng id
	 * @param key    key
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<List<Property>> propertyReader(final String thngId, final String key) throws EvrythngClientException {

		return get(String.format(PATH_THNG_PROPERTY, thngId, key), new TypeReference<List<Property>>() {

		});
	}

	/**
	 * Updates the {@link Property} named {@code key} of the referenced
	 * {@link Thng}.
	 * <p>
	 * PUT {@value #PATH_THNG_PROPERTY}
	 *
	 * @param thngId thng id
	 * @param key    key
	 * @param value  value
	 * @return a preconfigured {@link Builder}
	 * @see #propertiesCreator(String, Property)
	 */
	public Builder<List<Property>> propertyUpdater(final String thngId, final String key, final String value) throws EvrythngClientException {

		return propertyUpdater(thngId, key, new Property(null, value));
	}

	/**
	 * Updates the {@link Property} named {@code key} of the referenced
	 * {@link Thng}.
	 * <p>
	 * PUT {@value #PATH_THNG_PROPERTY}
	 *
	 * @param thngId    thng id
	 * @param key       key
	 * @param value     value
	 * @param timestamp timestamp
	 * @return a preconfigured {@link Builder}
	 * @see #propertiesCreator(String, Property)
	 */
	public Builder<List<Property>> propertyUpdater(final String thngId, final String key, final String value, final long timestamp) throws EvrythngClientException {

		return propertyUpdater(thngId, key, new Property(null, value, timestamp));
	}

	/**
	 * Updates the {@link Property} named {@code key} of the referenced
	 * {@link Thng}.
	 * <p>
	 * PUT {@value #PATH_THNG_PROPERTY}
	 *
	 * @param thngId thng id
	 * @param key    key
	 * @param value  value
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<List<Property>> propertyUpdater(final String thngId, final String key, final Property value) throws EvrythngClientException {

		return put(String.format(PATH_THNG_PROPERTY, thngId, key), Collections.singletonList(value), new TypeReference<List<Property>>() {

		});
	}

	/**
	 * Deletes the {@link Property} named {@code key} from the referenced
	 * {@link Thng}.
	 * <p>
	 * DELETE {@value #PATH_THNG_PROPERTY}
	 *
	 * @param thngId thng id
	 * @param key    key
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Boolean> propertyDeleter(final String thngId, final String key) throws EvrythngClientException {

		return delete(String.format(PATH_THNG_PROPERTY, thngId, key));
	}

	/* ***** /thngs/{id}/location ***** */

	/**
	 * Retrieves the last {@link Location} resources from the referenced
	 * {@link Thng}.
	 * <p>
	 * GET {@value #PATH_THNG_LOCATION}
	 *
	 * @param thngId thng id
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<List<Location>> locationReader(final String thngId) throws EvrythngClientException {

		return get(String.format(PATH_THNG_LOCATION, thngId), new TypeReference<List<Location>>() {

		});
	}

	/**
	 * Updates the current {@link Location} of the referenced {@link Thng}.
	 * <p>
	 * PUT {@value #PATH_THNG_LOCATION}
	 *
	 * @param thngId   thng id
	 * @param location {@link Location} instance
	 * @return a preconfigured {@link Builder}
	 * @see #locationUpdater(String, List)
	 */
	public Builder<List<Location>> locationUpdater(final String thngId, final Location location) throws EvrythngClientException {

		return locationUpdater(thngId, Collections.singletonList(location));
	}

	/**
	 * Updates the referenced {@link Thng} with multiple {@link Location}
	 * resources.
	 * <p>
	 * PUT {@value #PATH_THNG_LOCATION}
	 *
	 * @param thngId    thng id
	 * @param locations list of {@link Location}
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<List<Location>> locationUpdater(final String thngId, final List<Location> locations) throws EvrythngClientException {

		return put(String.format(PATH_THNG_LOCATION, thngId), locations, new TypeReference<List<Location>>() {

		});
	}

	/**
	 * Deletes the {@link Location} of the referenced {@link Thng}.
	 * <p>
	 * DELETE {@value #PATH_THNG_LOCATION}
	 *
	 * @param thngId thng id
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Boolean> locationDeleter(final String thngId) throws EvrythngClientException {

		return delete(String.format(PATH_THNG_LOCATION, thngId));
	}

	/* ***** /thngs/{id}/redirector ***** */

	/**
	 * Creates a redirector for the Thng.
	 *
	 * @param thngId      thng id
	 * @param redirection {@link Redirector} instance
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Redirector> redirectorCreator(final String thngId, final Redirector redirection) throws EvrythngClientException {

		return post(String.format(PATH_THNG_REDIRECTOR, thngId), redirection, new TypeReference<Redirector>() {

		});
	}

	/**
	 * Retrieves the redirector for the Thng.
	 *
	 * @param thngId thng id
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Redirector> redirectorReader(final String thngId) throws EvrythngClientException {

		return get(String.format(PATH_THNG_REDIRECTOR, thngId), new TypeReference<Redirector>() {

		});
	}

	/**
	 * Deletes the redirector for the Thng.
	 *
	 * @param thngId thng id
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Boolean> redirectorDeleter(final String thngId) throws EvrythngClientException {

		return delete(String.format(PATH_THNG_REDIRECTOR, thngId));
	}

	/**
	 * Updates the redirector for the Thng.
	 *
	 * @param thngId      thng id
	 * @param redirection {@link Redirector} instance
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Redirector> redirectorUpdater(final String thngId, final Redirector redirection) throws EvrythngClientException {

		return put(String.format(PATH_THNG_REDIRECTOR, thngId), redirection, new TypeReference<Redirector>() {

		});
	}

	/**
	 * Creates an action.
	 */
	public <T extends Action> Builder<T> actionCreator(final String thngId, final T action) throws EvrythngClientException {

		return (Builder<T>) post(String.format(PATH_THNG_TYPED_ACTIONS, thngId, action.getType()), action,
		                         new TypeReference<Action>() {

		                         });
	}

	/**
	 * Gets one action by actionId and type.
	 */
	@SuppressWarnings("unchecked")
	public <T extends Action> Builder<T> actionReader(final String thngId, final Class<T> actionClass, final String actionId) throws EvrythngClientException {

		String type = getType(actionClass);
		return (Builder<T>) get(String.format(PATH_THNG_TYPED_ACTION, thngId, type, actionId), new TypeReference<Action>() {

		});
	}

	/**
	 * Gets one action by actionId and type.
	 */
	public Builder<CustomAction> actionReader(final String thngId, final String customType, final String actionId) throws EvrythngClientException {

		checkCustomType(customType);
		return get(String.format(PATH_THNG_TYPED_ACTION, thngId, customType, actionId), new TypeReference<CustomAction>() {

		});
	}

	protected void checkCustomType(final String customType) {

		if (!customType.startsWith("_")) {
			throw new IllegalArgumentException("Custom types must start with '_' (underscore).");
		}
	}

	public <T extends Action> String getType(final Class<T> actionClass) {

		String type = deserializer.getActionType(actionClass);
		if (type == null) {
			throw new IllegalArgumentException("The action type is not recognized.");
		}
		return type;
	}

}
