/**
 */
package com.weltevree.harmonica.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Manufacturer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.weltevree.harmonica.model.Manufacturer#getName <em>Name</em>}</li>
 *   <li>{@link com.weltevree.harmonica.model.Manufacturer#getAddress <em>Address</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.weltevree.harmonica.model.ModelPackage#getManufacturer()
 * @model
 * @generated
 */
public interface Manufacturer extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.weltevree.harmonica.model.ModelPackage#getManufacturer_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.weltevree.harmonica.model.Manufacturer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' containment reference list.
	 * The list contents are of type {@link com.weltevree.harmonica.model.Address}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' containment reference list.
	 * @see com.weltevree.harmonica.model.ModelPackage#getManufacturer_Address()
	 * @model containment="true"
	 * @generated
	 */
	EList<Address> getAddress();

} // Manufacturer
