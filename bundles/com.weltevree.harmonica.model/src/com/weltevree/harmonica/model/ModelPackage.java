/**
 */
package com.weltevree.harmonica.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.weltevree.harmonica.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://weltevree.com/harmonica.xls";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.weltevree.harmonica";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = com.weltevree.harmonica.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.weltevree.harmonica.model.impl.HarmonicaImpl <em>Harmonica</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.weltevree.harmonica.model.impl.HarmonicaImpl
	 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getHarmonica()
	 * @generated
	 */
	int HARMONICA = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARMONICA__KEY = 0;

	/**
	 * The feature id for the '<em><b>Brand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARMONICA__BRAND = 1;

	/**
	 * The number of structural features of the '<em>Harmonica</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARMONICA_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.weltevree.harmonica.model.impl.TabImpl <em>Tab</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.weltevree.harmonica.model.impl.TabImpl
	 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getTab()
	 * @generated
	 */
	int TAB = 1;

	/**
	 * The feature id for the '<em><b>Author</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__AUTHOR = 0;

	/**
	 * The feature id for the '<em><b>Arranged</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__ARRANGED = 1;

	/**
	 * The feature id for the '<em><b>Tempo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB__TEMPO = 2;

	/**
	 * The number of structural features of the '<em>Tab</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.weltevree.harmonica.model.impl.KeyImpl <em>Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.weltevree.harmonica.model.impl.KeyImpl
	 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getKey()
	 * @generated
	 */
	int KEY = 2;

	/**
	 * The feature id for the '<em><b>Pitch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__PITCH = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__NAME = 1;

	/**
	 * The number of structural features of the '<em>Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.weltevree.harmonica.model.impl.BrandImpl <em>Brand</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.weltevree.harmonica.model.impl.BrandImpl
	 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getBrand()
	 * @generated
	 */
	int BRAND = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRAND__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Brand</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRAND_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.weltevree.harmonica.model.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.weltevree.harmonica.model.impl.PersonImpl
	 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NAME = 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ADDRESS = 1;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.weltevree.harmonica.model.impl.AddressImpl <em>Address</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.weltevree.harmonica.model.impl.AddressImpl
	 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getAddress()
	 * @generated
	 */
	int ADDRESS = 5;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__LINE = 0;

	/**
	 * The number of structural features of the '<em>Address</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.weltevree.harmonica.model.impl.ManufacturerImpl <em>Manufacturer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.weltevree.harmonica.model.impl.ManufacturerImpl
	 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getManufacturer()
	 * @generated
	 */
	int MANUFACTURER = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUFACTURER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUFACTURER__ADDRESS = 1;

	/**
	 * The number of structural features of the '<em>Manufacturer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUFACTURER_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link com.weltevree.harmonica.model.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.weltevree.harmonica.model.impl.GroupImpl
	 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__NAME = 0;

	/**
	 * The feature id for the '<em><b>Person</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__PERSON = 1;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.weltevree.harmonica.model.impl.StudentImpl <em>Student</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.weltevree.harmonica.model.impl.StudentImpl
	 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getStudent()
	 * @generated
	 */
	int STUDENT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDENT__NAME = PERSON__NAME;

	/**
	 * The feature id for the '<em><b>Address</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDENT__ADDRESS = PERSON__ADDRESS;

	/**
	 * The number of structural features of the '<em>Student</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDENT_FEATURE_COUNT = PERSON_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link com.weltevree.harmonica.model.Harmonica <em>Harmonica</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Harmonica</em>'.
	 * @see com.weltevree.harmonica.model.Harmonica
	 * @generated
	 */
	EClass getHarmonica();

	/**
	 * Returns the meta object for the reference '{@link com.weltevree.harmonica.model.Harmonica#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see com.weltevree.harmonica.model.Harmonica#getKey()
	 * @see #getHarmonica()
	 * @generated
	 */
	EReference getHarmonica_Key();

	/**
	 * Returns the meta object for the reference '{@link com.weltevree.harmonica.model.Harmonica#getBrand <em>Brand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Brand</em>'.
	 * @see com.weltevree.harmonica.model.Harmonica#getBrand()
	 * @see #getHarmonica()
	 * @generated
	 */
	EReference getHarmonica_Brand();

	/**
	 * Returns the meta object for class '{@link com.weltevree.harmonica.model.Tab <em>Tab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tab</em>'.
	 * @see com.weltevree.harmonica.model.Tab
	 * @generated
	 */
	EClass getTab();

	/**
	 * Returns the meta object for the containment reference list '{@link com.weltevree.harmonica.model.Tab#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Author</em>'.
	 * @see com.weltevree.harmonica.model.Tab#getAuthor()
	 * @see #getTab()
	 * @generated
	 */
	EReference getTab_Author();

	/**
	 * Returns the meta object for the containment reference list '{@link com.weltevree.harmonica.model.Tab#getArranged <em>Arranged</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arranged</em>'.
	 * @see com.weltevree.harmonica.model.Tab#getArranged()
	 * @see #getTab()
	 * @generated
	 */
	EReference getTab_Arranged();

	/**
	 * Returns the meta object for the attribute '{@link com.weltevree.harmonica.model.Tab#getTempo <em>Tempo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tempo</em>'.
	 * @see com.weltevree.harmonica.model.Tab#getTempo()
	 * @see #getTab()
	 * @generated
	 */
	EAttribute getTab_Tempo();

	/**
	 * Returns the meta object for class '{@link com.weltevree.harmonica.model.Key <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key</em>'.
	 * @see com.weltevree.harmonica.model.Key
	 * @generated
	 */
	EClass getKey();

	/**
	 * Returns the meta object for the attribute '{@link com.weltevree.harmonica.model.Key#getPitch <em>Pitch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pitch</em>'.
	 * @see com.weltevree.harmonica.model.Key#getPitch()
	 * @see #getKey()
	 * @generated
	 */
	EAttribute getKey_Pitch();

	/**
	 * Returns the meta object for the attribute '{@link com.weltevree.harmonica.model.Key#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.weltevree.harmonica.model.Key#getName()
	 * @see #getKey()
	 * @generated
	 */
	EAttribute getKey_Name();

	/**
	 * Returns the meta object for class '{@link com.weltevree.harmonica.model.Brand <em>Brand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Brand</em>'.
	 * @see com.weltevree.harmonica.model.Brand
	 * @generated
	 */
	EClass getBrand();

	/**
	 * Returns the meta object for the attribute '{@link com.weltevree.harmonica.model.Brand#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.weltevree.harmonica.model.Brand#getType()
	 * @see #getBrand()
	 * @generated
	 */
	EAttribute getBrand_Type();

	/**
	 * Returns the meta object for class '{@link com.weltevree.harmonica.model.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see com.weltevree.harmonica.model.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link com.weltevree.harmonica.model.Person#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.weltevree.harmonica.model.Person#getName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.weltevree.harmonica.model.Person#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address</em>'.
	 * @see com.weltevree.harmonica.model.Person#getAddress()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_Address();

	/**
	 * Returns the meta object for class '{@link com.weltevree.harmonica.model.Address <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address</em>'.
	 * @see com.weltevree.harmonica.model.Address
	 * @generated
	 */
	EClass getAddress();

	/**
	 * Returns the meta object for the attribute list '{@link com.weltevree.harmonica.model.Address#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Line</em>'.
	 * @see com.weltevree.harmonica.model.Address#getLine()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_Line();

	/**
	 * Returns the meta object for class '{@link com.weltevree.harmonica.model.Manufacturer <em>Manufacturer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manufacturer</em>'.
	 * @see com.weltevree.harmonica.model.Manufacturer
	 * @generated
	 */
	EClass getManufacturer();

	/**
	 * Returns the meta object for the attribute '{@link com.weltevree.harmonica.model.Manufacturer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.weltevree.harmonica.model.Manufacturer#getName()
	 * @see #getManufacturer()
	 * @generated
	 */
	EAttribute getManufacturer_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.weltevree.harmonica.model.Manufacturer#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Address</em>'.
	 * @see com.weltevree.harmonica.model.Manufacturer#getAddress()
	 * @see #getManufacturer()
	 * @generated
	 */
	EReference getManufacturer_Address();

	/**
	 * Returns the meta object for class '{@link com.weltevree.harmonica.model.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see com.weltevree.harmonica.model.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.weltevree.harmonica.model.Group#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.weltevree.harmonica.model.Group#getName()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.weltevree.harmonica.model.Group#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Person</em>'.
	 * @see com.weltevree.harmonica.model.Group#getPerson()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Person();

	/**
	 * Returns the meta object for class '{@link com.weltevree.harmonica.model.Student <em>Student</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Student</em>'.
	 * @see com.weltevree.harmonica.model.Student
	 * @generated
	 */
	EClass getStudent();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.weltevree.harmonica.model.impl.HarmonicaImpl <em>Harmonica</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.weltevree.harmonica.model.impl.HarmonicaImpl
		 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getHarmonica()
		 * @generated
		 */
		EClass HARMONICA = eINSTANCE.getHarmonica();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HARMONICA__KEY = eINSTANCE.getHarmonica_Key();

		/**
		 * The meta object literal for the '<em><b>Brand</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HARMONICA__BRAND = eINSTANCE.getHarmonica_Brand();

		/**
		 * The meta object literal for the '{@link com.weltevree.harmonica.model.impl.TabImpl <em>Tab</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.weltevree.harmonica.model.impl.TabImpl
		 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getTab()
		 * @generated
		 */
		EClass TAB = eINSTANCE.getTab();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAB__AUTHOR = eINSTANCE.getTab_Author();

		/**
		 * The meta object literal for the '<em><b>Arranged</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAB__ARRANGED = eINSTANCE.getTab_Arranged();

		/**
		 * The meta object literal for the '<em><b>Tempo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAB__TEMPO = eINSTANCE.getTab_Tempo();

		/**
		 * The meta object literal for the '{@link com.weltevree.harmonica.model.impl.KeyImpl <em>Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.weltevree.harmonica.model.impl.KeyImpl
		 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getKey()
		 * @generated
		 */
		EClass KEY = eINSTANCE.getKey();

		/**
		 * The meta object literal for the '<em><b>Pitch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY__PITCH = eINSTANCE.getKey_Pitch();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY__NAME = eINSTANCE.getKey_Name();

		/**
		 * The meta object literal for the '{@link com.weltevree.harmonica.model.impl.BrandImpl <em>Brand</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.weltevree.harmonica.model.impl.BrandImpl
		 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getBrand()
		 * @generated
		 */
		EClass BRAND = eINSTANCE.getBrand();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BRAND__TYPE = eINSTANCE.getBrand_Type();

		/**
		 * The meta object literal for the '{@link com.weltevree.harmonica.model.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.weltevree.harmonica.model.impl.PersonImpl
		 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NAME = eINSTANCE.getPerson_Name();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__ADDRESS = eINSTANCE.getPerson_Address();

		/**
		 * The meta object literal for the '{@link com.weltevree.harmonica.model.impl.AddressImpl <em>Address</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.weltevree.harmonica.model.impl.AddressImpl
		 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getAddress()
		 * @generated
		 */
		EClass ADDRESS = eINSTANCE.getAddress();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESS__LINE = eINSTANCE.getAddress_Line();

		/**
		 * The meta object literal for the '{@link com.weltevree.harmonica.model.impl.ManufacturerImpl <em>Manufacturer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.weltevree.harmonica.model.impl.ManufacturerImpl
		 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getManufacturer()
		 * @generated
		 */
		EClass MANUFACTURER = eINSTANCE.getManufacturer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANUFACTURER__NAME = eINSTANCE.getManufacturer_Name();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MANUFACTURER__ADDRESS = eINSTANCE.getManufacturer_Address();

		/**
		 * The meta object literal for the '{@link com.weltevree.harmonica.model.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.weltevree.harmonica.model.impl.GroupImpl
		 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__NAME = eINSTANCE.getGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Person</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__PERSON = eINSTANCE.getGroup_Person();

		/**
		 * The meta object literal for the '{@link com.weltevree.harmonica.model.impl.StudentImpl <em>Student</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.weltevree.harmonica.model.impl.StudentImpl
		 * @see com.weltevree.harmonica.model.impl.ModelPackageImpl#getStudent()
		 * @generated
		 */
		EClass STUDENT = eINSTANCE.getStudent();

	}

} //ModelPackage
