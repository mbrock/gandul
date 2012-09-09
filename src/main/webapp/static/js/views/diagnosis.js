var Gandul = {};

Gandul.Diagnosis = {};

Gandul.Diagnosis.initialize = function () {
    var Diagnosis = Backbone.Model.extend({});

    var Diagnoses = Backbone.Collection.extend({
        model: Diagnosis
    });

    var diagnoses = new Diagnoses;

    Gandul.Diagnosis.addMany = function (diagnoses) {
        _.each(diagnoses, function (diagnosis) {
           diagnoses.add(diagnosis);
        });
    };

    var DiagnosisView = Backbone.View.extend({
        tagName: 'div',
        className: 'row',
        template: $('#diagnosis-template').html(),

        render: function () {
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        }
    });

    var DiagnosesView = Backbone.View.extend({
        el: '#diagnoses',

        initialize: function () {
            diagnoses.on('add', this.add, this);
        },

        add: function (diagnosis) {
            var view = new DiagnosisView({model: diagnosis});
            this.$el.append(view.render());
        }
    });

    new DiagnosesView;
};