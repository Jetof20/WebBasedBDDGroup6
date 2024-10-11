package dk.sdu.bdd.xtext.scoping;

import com.google.common.collect.Iterables;
import dk.sdu.bdd.xtext.bddDsl.ActionDef;
import dk.sdu.bdd.xtext.bddDsl.BddDslPackage;
import dk.sdu.bdd.xtext.bddDsl.DeclarativeEntityDef;
import dk.sdu.bdd.xtext.bddDsl.DeclarativeEntityRef;
import dk.sdu.bdd.xtext.bddDsl.ImperativeActionDef;
import dk.sdu.bdd.xtext.bddDsl.ImperativeEntityDef;
import dk.sdu.bdd.xtext.bddDsl.ImperativeEntityRef;
import dk.sdu.bdd.xtext.bddDsl.ImperativePropertyDef;
import dk.sdu.bdd.xtext.bddDsl.ImperativeStateName;
import dk.sdu.bdd.xtext.bddDsl.Model;
import dk.sdu.bdd.xtext.bddDsl.ModelRef;
import dk.sdu.bdd.xtext.bddDsl.PropertyDef;
import dk.sdu.bdd.xtext.bddDsl.StateName;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class BddDslScopeProvider extends AbstractBddDslScopeProvider {
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    IScope _xifexpression = null;
    EClassifier _eType = reference.getEType();
    EClass _stateName = BddDslPackage.eINSTANCE.getStateName();
    boolean _equals = Objects.equals(_eType, _stateName);
    if (_equals) {
      _xifexpression = this.<StateName>scopeForDecEntityModelElements(context, StateName.class);
    } else {
      IScope _xifexpression_1 = null;
      EClassifier _eType_1 = reference.getEType();
      EClass _actionDef = BddDslPackage.eINSTANCE.getActionDef();
      boolean _equals_1 = Objects.equals(_eType_1, _actionDef);
      if (_equals_1) {
        _xifexpression_1 = this.<ActionDef>scopeForDecEntityModelElements(context, ActionDef.class);
      } else {
        IScope _xifexpression_2 = null;
        EClassifier _eType_2 = reference.getEType();
        EClass _propertyDef = BddDslPackage.eINSTANCE.getPropertyDef();
        boolean _equals_2 = Objects.equals(_eType_2, _propertyDef);
        if (_equals_2) {
          _xifexpression_2 = this.<PropertyDef>scopeForDecEntityModelElements(context, PropertyDef.class);
        } else {
          IScope _xifexpression_3 = null;
          EClassifier _eType_3 = reference.getEType();
          EClass _imperativeActionDef = BddDslPackage.eINSTANCE.getImperativeActionDef();
          boolean _equals_3 = Objects.equals(_eType_3, _imperativeActionDef);
          if (_equals_3) {
            _xifexpression_3 = this.<ImperativeActionDef>scopeForImpEntityModelElements(context, ImperativeActionDef.class);
          } else {
            IScope _xifexpression_4 = null;
            EClassifier _eType_4 = reference.getEType();
            EClass _imperativePropertyDef = BddDslPackage.eINSTANCE.getImperativePropertyDef();
            boolean _equals_4 = Objects.equals(_eType_4, _imperativePropertyDef);
            if (_equals_4) {
              _xifexpression_4 = this.<ImperativePropertyDef>scopeForImpEntityModelElements(context, ImperativePropertyDef.class);
            } else {
              IScope _xifexpression_5 = null;
              EClassifier _eType_5 = reference.getEType();
              EClass _imperativeStateName = BddDslPackage.eINSTANCE.getImperativeStateName();
              boolean _equals_5 = Objects.equals(_eType_5, _imperativeStateName);
              if (_equals_5) {
                _xifexpression_5 = this.<ImperativeStateName>scopeForImpEntityModelElements(context, ImperativeStateName.class);
              } else {
                IScope _xifexpression_6 = null;
                EClassifier _eType_6 = reference.getEType();
                EClass _imperativeEntityDef = BddDslPackage.eINSTANCE.getImperativeEntityDef();
                boolean _equals_6 = Objects.equals(_eType_6, _imperativeEntityDef);
                if (_equals_6) {
                  _xifexpression_6 = Scopes.scopeFor(this.getAllImpEntityDefs(this.<Model>findAncestorOfType(context, Model.class)));
                } else {
                  IScope _xifexpression_7 = null;
                  EClassifier _eType_7 = reference.getEType();
                  EClass _declarativeEntityDef = BddDslPackage.eINSTANCE.getDeclarativeEntityDef();
                  boolean _equals_7 = Objects.equals(_eType_7, _declarativeEntityDef);
                  if (_equals_7) {
                    _xifexpression_7 = Scopes.scopeFor(this.getAllDecEntityDefs(this.<Model>findAncestorOfType(context, Model.class)));
                  } else {
                    _xifexpression_7 = super.getScope(context, reference);
                  }
                  _xifexpression_6 = _xifexpression_7;
                }
                _xifexpression_5 = _xifexpression_6;
              }
              _xifexpression_4 = _xifexpression_5;
            }
            _xifexpression_3 = _xifexpression_4;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  public Iterable<? extends DeclarativeEntityDef> getAllDecEntityDefs(final Model model) {
    ArrayList<DeclarativeEntityDef> _xblockexpression = null;
    {
      final ArrayList<DeclarativeEntityDef> allDecEntityDefs = CollectionLiterals.<DeclarativeEntityDef>newArrayList();
      EList<DeclarativeEntityDef> _declarativeEntityDef = model.getDeclarativeEntityDef();
      Iterables.<DeclarativeEntityDef>addAll(allDecEntityDefs, _declarativeEntityDef);
      EList<ModelRef> _modelRefs = model.getModelRefs();
      for (final ModelRef modelRef : _modelRefs) {
        Iterable<? extends DeclarativeEntityDef> _allDecEntityDefs = this.getAllDecEntityDefs(modelRef.getModelRef());
        Iterables.<DeclarativeEntityDef>addAll(allDecEntityDefs, _allDecEntityDefs);
      }
      _xblockexpression = allDecEntityDefs;
    }
    return _xblockexpression;
  }

  public Iterable<? extends ImperativeEntityDef> getAllImpEntityDefs(final Model model) {
    ArrayList<ImperativeEntityDef> _xblockexpression = null;
    {
      final ArrayList<ImperativeEntityDef> allImpEntityDefs = CollectionLiterals.<ImperativeEntityDef>newArrayList();
      EList<ImperativeEntityDef> _imperativeEntityDef = model.getImperativeEntityDef();
      Iterables.<ImperativeEntityDef>addAll(allImpEntityDefs, _imperativeEntityDef);
      EList<ModelRef> _modelRefs = model.getModelRefs();
      for (final ModelRef modelRef : _modelRefs) {
        Iterable<? extends ImperativeEntityDef> _allImpEntityDefs = this.getAllImpEntityDefs(modelRef.getModelRef());
        Iterables.<ImperativeEntityDef>addAll(allImpEntityDefs, _allImpEntityDefs);
      }
      _xblockexpression = allImpEntityDefs;
    }
    return _xblockexpression;
  }

  public <T extends EObject> IScope scopeForImpEntityModelElements(final EObject context, final Class<T> clazz) {
    IScope _xblockexpression = null;
    {
      final ArrayList<T> allImpModelElements = CollectionLiterals.<T>newArrayList();
      final ArrayList<ImperativeEntityDef> impEntityDefs = CollectionLiterals.<ImperativeEntityDef>newArrayList();
      final ImperativeEntityDef contextImpEntityDef = this.findImpWEntityDef(context);
      if ((contextImpEntityDef != null)) {
        impEntityDefs.add(contextImpEntityDef);
      } else {
        Iterable<? extends ImperativeEntityDef> _allImpEntityDefs = this.getAllImpEntityDefs(this.<Model>findAncestorOfType(context, Model.class));
        Iterables.<ImperativeEntityDef>addAll(impEntityDefs, _allImpEntityDefs);
      }
      for (final ImperativeEntityDef entityDef : impEntityDefs) {
        Iterable<T> _allInheritedContentsOfType = this.<T>getAllInheritedContentsOfType(entityDef, clazz);
        for (final T modelElement : _allInheritedContentsOfType) {
          allImpModelElements.add(modelElement);
        }
      }
      _xblockexpression = Scopes.scopeFor(allImpModelElements);
    }
    return _xblockexpression;
  }

  public <T extends EObject> IScope scopeForDecEntityModelElements(final EObject context, final Class<T> clazz) {
    IScope _xblockexpression = null;
    {
      final ArrayList<T> allDecModelElements = CollectionLiterals.<T>newArrayList();
      final ArrayList<DeclarativeEntityDef> decEntityDefs = CollectionLiterals.<DeclarativeEntityDef>newArrayList();
      final DeclarativeEntityDef contextDecEntityDef = this.findDecWEntityDef(context);
      if ((contextDecEntityDef != null)) {
        decEntityDefs.add(contextDecEntityDef);
      } else {
        Iterable<? extends DeclarativeEntityDef> _allDecEntityDefs = this.getAllDecEntityDefs(this.<Model>findAncestorOfType(context, Model.class));
        Iterables.<DeclarativeEntityDef>addAll(decEntityDefs, _allDecEntityDefs);
      }
      for (final DeclarativeEntityDef entityDef : decEntityDefs) {
        Iterable<T> _allInheritedContentsOfType = this.<T>getAllInheritedContentsOfType(entityDef, clazz);
        for (final T modelElement : _allInheritedContentsOfType) {
          allDecModelElements.add(modelElement);
        }
      }
      _xblockexpression = Scopes.scopeFor(allDecModelElements);
    }
    return _xblockexpression;
  }

  public <T extends EObject> Iterable<T> getAllInheritedContentsOfType(final DeclarativeEntityDef declarativeEntityDef, final Class<T> clazz) {
    Iterable<T> _xblockexpression = null;
    {
      final ArrayList<T> all = CollectionLiterals.<T>newArrayList();
      List<T> _allContentsOfType = EcoreUtil2.<T>getAllContentsOfType(declarativeEntityDef, clazz);
      Iterables.<T>addAll(all, _allContentsOfType);
      final Consumer<DeclarativeEntityDef> _function = (DeclarativeEntityDef it) -> {
        Iterable<T> _allInheritedContentsOfType = this.<T>getAllInheritedContentsOfType(it, clazz);
        Iterables.<T>addAll(all, _allInheritedContentsOfType);
      };
      declarativeEntityDef.getSuperEntities().forEach(_function);
      final Function1<T, Boolean> _function_1 = (T it) -> {
        return Boolean.valueOf(clazz.isInstance(it));
      };
      _xblockexpression = IterableExtensions.<T>filter(all, _function_1);
    }
    return _xblockexpression;
  }

  public DeclarativeEntityDef findDecWEntityDef(final EObject context) {
    DeclarativeEntityDef _xblockexpression = null;
    {
      final Function1<EStructuralFeature, Boolean> _function = (EStructuralFeature it) -> {
        EClassifier _eType = it.getEType();
        EClass _declarativeEntityRef = BddDslPackage.eINSTANCE.getDeclarativeEntityRef();
        return Boolean.valueOf(Objects.equals(_eType, _declarativeEntityRef));
      };
      final EStructuralFeature feature = IterableExtensions.<EStructuralFeature>findFirst(context.eClass().getEAllStructuralFeatures(), _function);
      DeclarativeEntityDef _xifexpression = null;
      if ((feature != null)) {
        Object _eGet = context.eGet(feature);
        DeclarativeEntityDef _entity = null;
        if (((DeclarativeEntityRef) _eGet)!=null) {
          _entity=((DeclarativeEntityRef) _eGet).getEntity();
        }
        _xifexpression = _entity;
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  public <T extends EObject> Iterable<T> getAllInheritedContentsOfType(final ImperativeEntityDef imperativeEntityDef, final Class<T> clazz) {
    Iterable<T> _xblockexpression = null;
    {
      final ArrayList<T> all = CollectionLiterals.<T>newArrayList();
      List<T> _allContentsOfType = EcoreUtil2.<T>getAllContentsOfType(imperativeEntityDef, clazz);
      Iterables.<T>addAll(all, _allContentsOfType);
      final Consumer<ImperativeEntityDef> _function = (ImperativeEntityDef it) -> {
        Iterable<T> _allInheritedContentsOfType = this.<T>getAllInheritedContentsOfType(it, clazz);
        Iterables.<T>addAll(all, _allInheritedContentsOfType);
      };
      imperativeEntityDef.getSuperEntities().forEach(_function);
      final Function1<T, Boolean> _function_1 = (T it) -> {
        return Boolean.valueOf(clazz.isInstance(it));
      };
      _xblockexpression = IterableExtensions.<T>filter(all, _function_1);
    }
    return _xblockexpression;
  }

  public ImperativeEntityDef findImpWEntityDef(final EObject context) {
    ImperativeEntityDef _xblockexpression = null;
    {
      final Function1<EStructuralFeature, Boolean> _function = (EStructuralFeature it) -> {
        EClassifier _eType = it.getEType();
        EClass _imperativeEntityRef = BddDslPackage.eINSTANCE.getImperativeEntityRef();
        return Boolean.valueOf(Objects.equals(_eType, _imperativeEntityRef));
      };
      final EStructuralFeature feature = IterableExtensions.<EStructuralFeature>findFirst(context.eClass().getEAllStructuralFeatures(), _function);
      ImperativeEntityDef _xifexpression = null;
      if ((feature != null)) {
        Object _eGet = context.eGet(feature);
        ImperativeEntityDef _entity = null;
        if (((ImperativeEntityRef) _eGet)!=null) {
          _entity=((ImperativeEntityRef) _eGet).getEntity();
        }
        _xifexpression = _entity;
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  public <T extends Object> T findAncestorOfType(final EObject context, final Class<T> clazz) {
    EObject parent = context;
    while ((parent != null)) {
      {
        boolean _isInstance = clazz.isInstance(parent);
        if (_isInstance) {
          return ((T) parent);
        }
        parent = parent.eContainer();
      }
    }
    return null;
  }
}
