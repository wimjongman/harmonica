/**
 */
package com.weltevree.harmonica.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.weltevree.harmonica.model.ModelPackage;
import com.weltevree.harmonica.model.Person;
import com.weltevree.harmonica.model.Tab;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tab</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.weltevree.harmonica.model.impl.TabImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link com.weltevree.harmonica.model.impl.TabImpl#getArranged <em>Arranged</em>}</li>
 *   <li>{@link com.weltevree.harmonica.model.impl.TabImpl#getTempo <em>Tempo</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TabImpl extends EObjectImpl implements Tab {
	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> author;

	/**
	 * The cached value of the '{@link #getArranged() <em>Arranged</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArranged()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> arranged;

	/**
	 * The default value of the '{@link #getTempo() <em>Tempo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTempo()
	 * @generated
	 * @ordered
	 */
	protected static final int TEMPO_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTempo() <em>Tempo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTempo()
	 * @generated
	 * @ordered
	 */
	protected int tempo = TEMPO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TabImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.TAB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getAuthor() {
		if (author == null) {
			author = new EObjectContainmentEList<Person>(Person.class, this, ModelPackage.TAB__AUTHOR);
		}
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getArranged() {
		if (arranged == null) {
			arranged = new EObjectContainmentEList<Person>(Person.class, this, ModelPackage.TAB__ARRANGED);
		}
		return arranged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTempo() {
		return tempo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTempo(int newTempo) {
		int oldTempo = tempo;
		tempo = newTempo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TAB__TEMPO, oldTempo, tempo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.TAB__AUTHOR:
				return ((InternalEList<?>)getAuthor()).basicRemove(otherEnd, msgs);
			case ModelPackage.TAB__ARRANGED:
				return ((InternalEList<?>)getArranged()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.TAB__AUTHOR:
				return getAuthor();
			case ModelPackage.TAB__ARRANGED:
				return getArranged();
			case ModelPackage.TAB__TEMPO:
				return getTempo();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.TAB__AUTHOR:
				getAuthor().clear();
				getAuthor().addAll((Collection<? extends Person>)newValue);
				return;
			case ModelPackage.TAB__ARRANGED:
				getArranged().clear();
				getArranged().addAll((Collection<? extends Person>)newValue);
				return;
			case ModelPackage.TAB__TEMPO:
				setTempo((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.TAB__AUTHOR:
				getAuthor().clear();
				return;
			case ModelPackage.TAB__ARRANGED:
				getArranged().clear();
				return;
			case ModelPackage.TAB__TEMPO:
				setTempo(TEMPO_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.TAB__AUTHOR:
				return author != null && !author.isEmpty();
			case ModelPackage.TAB__ARRANGED:
				return arranged != null && !arranged.isEmpty();
			case ModelPackage.TAB__TEMPO:
				return tempo != TEMPO_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (tempo: ");
		result.append(tempo);
		result.append(')');
		return result.toString();
	}

} //TabImpl
