export const URI_SERVER_API = 'http://localhost:8080/api/sistema-de-seguranca-digital'

export const DATATABLE_OPTIONS = {
  bLengthChange: false,
  bFilter: false,
  order: [4, 'asc'],
  retrieve: true,
  destroy: true,
  columnDefs: [{
    orderable: false, targets: 'no-sort'
  }],
  language: {
    paginate: {
      first: '<i class="fa fa-chevron-left"></i><i class="fa fa-chevron-left"></i>',
      last: '<i class="fa fa-chevron-right"></i><i class="fa fa-chevron-right"></i>',
      previous: '<i class="fa fa-chevron-left"></i>',
      next: '<i class="fa fa-chevron-right"></i>'
    }
  }
}
