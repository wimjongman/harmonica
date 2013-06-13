/**
 */
package com.weltevree.harmonica.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tab</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.weltevree.harmonica.model.Tab#getAuthor <em>Author</em>}</li>
 *   <li>{@link com.weltevree.harmonica.model.Tab#getArranged <em>Arranged</em>}</li>
 *   <li>{@link com.weltevree.harmonica.model.Tab#getTempo <em>Tempo</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.weltevree.harmonica.model.ModelPackage#getTab()
 * @model
 * @generated
 */
public interface Tab extends EObject {
	/**
	 * Returns the value of the '<em><b>Author</b></em>' containment reference list.
	 * The list contents are of type {@link com.weltevree.harmonica.model.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' containment reference list.
	 * @see com.weltevree.harmonica.model.ModelPackage#getTab_Author()
	 * @model containment="true"
	 * @generated
	 */
	EList<Person> getAuthor();

	/**
	 * Returns the value of the '<em><b>Arranged</b></em>' containment reference list.
	 * The list contents are of type {@link com.weltevree.harmonica.model.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arranged</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arranged</em>' containment reference list.
	 * @see com.weltevree.harmonica.model.ModelPackage#getTab_Arranged()
	 * @model containment="true"
	 * @generated
	 */
	EList<Person> getArranged();

	/**
	 * Returns the value of the '<em><b>Tempo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tempo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tempo</em>' attribute.
	 * @see #setTempo(int)
	 * @see com.weltevree.harmonica.model.ModelPackage#getTab_Tempo()
	 * @model required="true"
	 * @generated
	 */
	int getTempo();

	/**
	 * Sets the value of the '{@link com.weltevree.harmonica.model.Tab#getTempo <em>Tempo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tempo</em>' attribute.
	 * @see #getTempo()
	 * @generated
	 */
	void setTempo(int value);

} // Tab
