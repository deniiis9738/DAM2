# -*- coding: utf-8 -*-

from odoo import models, fields, api

class lapeliculera_pelicula(models.Model):
    _name = 'lapeliculera.pelicula'
    _description = 'Pelicula'
    name = fields.Char(string = "Título", required = True, help = "Introduce el título de la película")
    director = fields.Char(string = "Director", requires = True, help = "Introduce el director")
    color = fields.Boolean(string = "Color")
    duracion = fields.Integer(string = "Duración en minutos")
    industria = fields.Selection([('0', 'Hollywood'), ('1', 'Europea'), ('2', 'Bollywood'), ('3', 'Otras')], default = "1", string = "Industria")
    fecha = fields.Date(string = "Fecha de estreno en España")
    sinopsis = fields.Text(string = "Sinopsis")
#   Una Película debe pertenecer a un Género. No se indica campo por lo que por defecto cogerá name
    genero = fields.Many2one("lapeliculera.genero", string = "Género", required = True)

class lapeliculera_genero(models.Model):
    _name = 'lapeliculera.genero'
    _description = 'Género cinematográfico'
    name = fields.Char(string = "Género", required = True, help = "Introduce el género cinematográfico")
    comentario = fields.Text(string = "Comentarios")
#   Cada género puede contener varias películas. En el caso One2many hay que especificar el campo de relación
    pelicula = fields.One2many("lapeliculera.pelicula", "genero", string = "Películas")
#
#     @api.depends('value')
#     def _value_pc(self):
#         for record in self:
#             record.value2 = float(record.value) / 100
