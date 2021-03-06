package com.evrythng.java.wrapper.service;

import com.evrythng.java.wrapper.ApiManager;
import com.evrythng.java.wrapper.core.EvrythngApiBuilder.Builder;
import com.evrythng.java.wrapper.core.EvrythngServiceBase;
import com.evrythng.java.wrapper.exception.EvrythngClientException;
import com.evrythng.thng.resource.model.store.Collection;
import com.evrythng.thng.resource.model.store.Thng;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collections;
import java.util.List;

/**
 * Service wrapper for the {@code /collections} endpoint of the EVRYTHNG API.
 *
 * @author Pedro De Almeida (almeidap)
 */
public class CollectionService extends EvrythngServiceBase {

	public static final String PATH_COLLECTIONS = "/collections";
	public static final String PATH_COLLECTION = PATH_COLLECTIONS + "/%s";
	public static final String PATH_COLLECTION_THNGS = PATH_COLLECTION + "/thngs";
	public static final String PATH_COLLECTION_THNG = PATH_COLLECTION_THNGS + "/%s";

	public CollectionService(final ApiManager apiManager) {

		super(apiManager);
	}

	/* ***** /collections ***** */

	/**
	 * Creates a new {@link Collection}.
	 * <p>
	 * POST {@value #PATH_COLLECTIONS}
	 *
	 * @param collection the instant holding the {@link Collection} resource data
	 * @return a {@link Collection} creator
	 */
	public Builder<Collection> collectionCreator(final Collection collection) throws EvrythngClientException {

		return post(PATH_COLLECTIONS, collection, new TypeReference<Collection>() {

		});
	}

	/**
	 * Retrieves the last updated {@link Collection} resources.
	 * <p>
	 * GET {@value #PATH_COLLECTIONS}
	 *
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<List<Collection>> collectionsReader() throws EvrythngClientException {

		return get(PATH_COLLECTIONS, new TypeReference<List<Collection>>() {

		});
	}

	/* ***** /collections/{id} ***** */

	/**
	 * Retrieves the referenced {@link Collection}.
	 * <p>
	 * GET {@value #PATH_COLLECTION}
	 *
	 * @param collectionId collection id
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Collection> collectionReader(final String collectionId) throws EvrythngClientException {

		return get(String.format(PATH_COLLECTION, collectionId), new TypeReference<Collection>() {

		});
	}

	/**
	 * Updates the referenced {@link Collection}.
	 * <p>
	 * PUT {@value #PATH_COLLECTION}
	 *
	 * @param collectionId collection id
	 * @param collection   {@link Collection} instance
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Collection> collectionUpdater(final String collectionId, final Collection collection) throws EvrythngClientException {

		return put(String.format(PATH_COLLECTION, collectionId), collection, new TypeReference<Collection>() {

		});
	}

	/**
	 * Deletes the referenced {@link Collection}.
	 * <p>
	 * DELETE {@value #PATH_COLLECTION}
	 *
	 * @param collectionId collection id
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Boolean> collectionDeleter(final String collectionId) throws EvrythngClientException {

		return delete(String.format(PATH_COLLECTION, collectionId));
	}

	/* ***** /collections/{id}/thngs ***** */

	/**
	 * Retrieves the last updated {@link Thng} resources linked with the
	 * referenced {@link Collection}.
	 * <p>
	 * GET {@value #PATH_COLLECTION_THNGS}
	 *
	 * @param collectionId collection id
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<List<Thng>> thngsReader(final String collectionId) throws EvrythngClientException {

		return get(String.format(PATH_COLLECTION_THNGS, collectionId), new TypeReference<List<Thng>>() {

		});
	}

	/**
	 * Adds the referenced {@link Thng} to the provided {@link Collection}.
	 * <p>
	 * PUT {@value #PATH_COLLECTION_THNGS}
	 *
	 * @param collectionId collection id
	 * @param thngId       thng id
	 * @return a preconfigured {@link Builder}
	 * @see #thngsAdder(String, List)
	 */
	public Builder<List<String>> thngAdder(final String collectionId, final String thngId) throws EvrythngClientException {

		return thngsAdder(collectionId, Collections.singletonList(thngId));
	}

	/**
	 * Adds the referenced {@link Thng} resources to the provided
	 * {@link Collection}.
	 * <p>
	 * PUT {@value #PATH_COLLECTION_THNGS}
	 *
	 * @param collectionId collection id
	 * @param thngs        list of thng ids
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<List<String>> thngsAdder(final String collectionId, final List<String> thngs) throws EvrythngClientException {

		return put(String.format(PATH_COLLECTION_THNGS, collectionId), thngs, new TypeReference<List<String>>() {

		});
	}

	/* ***** /collections/{id}/thngs/{id} ***** */

	/**
	 * Removes the referenced {@link Thng} from the provided {@link Collection}.
	 * <p>
	 * DELETE {@value #PATH_COLLECTION_THNG}
	 *
	 * @param collectionId collection id
	 * @param thngId       thng id
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Boolean> thngRemover(final String collectionId, final String thngId) throws EvrythngClientException {

		return delete(String.format(PATH_COLLECTION_THNG, collectionId, thngId));
	}

	/**
	 * Removes all {@link Thng} resources from the provided {@link Collection}.
	 * <p>
	 * DELETE {@value #PATH_COLLECTION_THNGS}
	 *
	 * @param collectionId collection id
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Boolean> thngsRemover(final String collectionId) throws EvrythngClientException {

		return delete(String.format(PATH_COLLECTION_THNGS, collectionId));
	}
}
