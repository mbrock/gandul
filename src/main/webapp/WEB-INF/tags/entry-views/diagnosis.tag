<%@ attribute name="entry" required="true" rtexprvalue="true" type="se.mbrock.gandul.journal.DiagnosisJournalEntry" %>
<%@ taglib prefix="gandul" tagdir="/WEB-INF/tags" %>

<script src="/static/js/views/diagnosis.js"></script>

<script type="text/template" id="diagnosis-template">
    <div class="well span4">
        <input type="text" placeholder="Text" />
        <label class="checkbox">
            <input type="checkbox" /> Kronisk
        </label>
    </div>
</script>

<script>
    $(document).ready(function () {
       Gandul.Diagnosis.addMany(
               <gandul:jsonify value="${entry.diagnoses}" />
       );
    });
</script>

<form>
    <legend>Diagnos</legend>

    <div id="diagnoses"></div>

    <div class="form-actions">
        <button type="button" class="btn btn-primary"><i class="icon-ok icon-white"></i> Spara</button>
        <button type="button" class="btn"><i class="icon-plus"></i> L&auml;gg till diagnos</button>
        <button type="button" class="btn">Avbryt</button>
    </div>
</form>
