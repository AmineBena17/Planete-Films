package services;

import entities.Tournagefilmcourt;
import services.util.JsfUtil;
import services.util.JsfUtil.PersistAction;
import beans.TournagefilmcourtFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("tournagefilmcourtController")
@SessionScoped
public class TournagefilmcourtController implements Serializable {

    @EJB
    private beans.TournagefilmcourtFacade ejbFacade;
    private List<Tournagefilmcourt> items = null;
    private Tournagefilmcourt selected;

    public TournagefilmcourtController() {
    }

    public Tournagefilmcourt getSelected() {
        return selected;
    }

    public void setSelected(Tournagefilmcourt selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TournagefilmcourtFacade getFacade() {
        return ejbFacade;
    }

    public Tournagefilmcourt prepareCreate() {
        selected = new Tournagefilmcourt();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TournagefilmcourtCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TournagefilmcourtUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TournagefilmcourtDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Tournagefilmcourt> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Tournagefilmcourt getTournagefilmcourt(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Tournagefilmcourt> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tournagefilmcourt> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tournagefilmcourt.class)
    public static class TournagefilmcourtControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TournagefilmcourtController controller = (TournagefilmcourtController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tournagefilmcourtController");
            return controller.getTournagefilmcourt(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Tournagefilmcourt) {
                Tournagefilmcourt o = (Tournagefilmcourt) object;
                return getStringKey(o.getIdTournagefilm());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tournagefilmcourt.class.getName()});
                return null;
            }
        }

    }

}
