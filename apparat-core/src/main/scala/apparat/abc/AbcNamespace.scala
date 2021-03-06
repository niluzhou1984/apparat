/*
 * This file is part of Apparat.
 *
 * Copyright (C) 2010 Joa Ebert
 * http://www.joa-ebert.com/
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package apparat.abc

object AbcNamespaceKind {
	val Namespace = 0x08
	val Package = 0x16
	val PackageInternal = 0x17
	val Protected = 0x18
	val Explicit = 0x19
	val StaticProtected = 0x1a
	val Private = 0x05
}

sealed case class AbcNamespace(kind: Int, name: Symbol) {
	override def equals(that: Any) = {
		that match {
			case that: AnyRef if this eq that => true
			case AbcNamespace(AbcNamespaceKind.Private, thatName) => false
			case AbcNamespace(thatKind, thatName) => thatKind == kind && thatName == name
			case _ => false
		}
	}
}
