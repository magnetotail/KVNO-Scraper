package de.foospace.two.domain.filter;

import java.util.List;

public class FilterModel {

    private List<BarrierefreiheitFilter> barrierefreiheitFilter;
    private List<BehandlungsprogrammFilter> behandlungsprogrammFilter;
    private List<ErreichbarkeitTagFilter> erreichbarkeitTagFilter;
    private List<ErreichbarkeitZeitFilter> erreichbarkeitZeitFilter;
    private List<FachgebieteFilter> fachgebieteFilter;
    private List<FremdsprachenFilter> fremdsprachenFilter;
    private List<GeschlechtFilter> geschlechtFilter;
    private List<PsychotherapieVerfahrenFilter> psychotherapieVerfahrenFilter;
    private List<SchwerpunkteFilter> schwerpunkteFilter;

    public List<BarrierefreiheitFilter> getBarrierefreiheitFilter() {
        return barrierefreiheitFilter;
    }

    public List<BehandlungsprogrammFilter> getBehandlungsprogrammFilter() {
        return behandlungsprogrammFilter;
    }

    public List<ErreichbarkeitTagFilter> getErreichbarkeitTagFilter() {
        return erreichbarkeitTagFilter;
    }

    public List<ErreichbarkeitZeitFilter> getErreichbarkeitZeitFilter() {
        return erreichbarkeitZeitFilter;
    }

    public List<FachgebieteFilter> getFachgebieteFilter() {
        return fachgebieteFilter;
    }

    public List<FremdsprachenFilter> getFremdsprachenFilter() {
        return fremdsprachenFilter;
    }

    public List<GeschlechtFilter> getGeschlechtFilter() {
        return geschlechtFilter;
    }

    public List<PsychotherapieVerfahrenFilter> getPsychotherapieVerfahrenFilter() {
        return psychotherapieVerfahrenFilter;
    }

    public List<SchwerpunkteFilter> getSchwerpunkteFilter() {
        return schwerpunkteFilter;
    }

    public List<ZusatzbezeichnungFilter> getZusatzbezeichnungFilter() {
        return zusatzbezeichnungFilter;
    }

    private List<ZusatzbezeichnungFilter> zusatzbezeichnungFilter;
}
